package com.api.calculate.shared.util.query;

import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

import org.springframework.util.StringUtils;

public class Condition {

    private final Column column;
    private final Operator operator;
    private final Object value;

    public Condition ( Column column, Operator operator, Object value ) {
        this.column = column;
        this.operator = operator;
        this.value = value;
    }

    public Condition ( Object value ) {
        this.value = value;
        this.column = null;
        this.operator = null;
    }

    public Condition ( Condition condition1, Condition condition2 ) {
        this.value = "( " + condition1.toString() + " AND " + condition2.toString() + " )";
        this.column = null;
        this.operator = null;
    }

    @Override
    public String toString () {
        if ( column == null || operator == null ) {
            return value.toString();
        }

        StringBuilder condition = new StringBuilder();

        if ( column instanceof JsonArrayColumn ) {
            JsonArrayColumn jsonArrayColumn = JsonArrayColumn.class.cast( column );


                condition.append( "( EXISTS ( SELECT 1 FROM jsonb_array_elements( " );
                condition.append( jsonArrayColumn.getName() );
                condition.append( " -> " );
                condition.append( "'" ).append( jsonArrayColumn.getKey() ).append( "'" );
                condition.append( " ) AS JSON( data ) WHERE" );
                if ( jsonArrayColumn.isLowerCase() ) {
                    condition.append( " LOWER( data #>> '{" ).append( jsonArrayColumn.getItemKey() ).append( "}' )" );
                } else {
                    condition.append( " data #>> '{" ).append( jsonArrayColumn.getItemKey() ).append( "}'" );
                }
                condition.append( operator.toString() );
                condition.append( jsonArrayColumn.isLowerCase() ? getValue().toLowerCase() : getValue() );
            condition.append( " )" );
            if ( operator.equals( Operator.NULL )
                || operator.equals( Operator.NOT_LIKE )
                || operator.equals( Operator.NOT_EQUAL ) ) {

                condition.append( " OR " ).append( column.getName() );
                condition.append( " ->> '" ).append( jsonArrayColumn.getKey() ).append( "' IS NULL " );
            } else if ( operator.equals( Operator.NOT_NULL ) ) {
                condition.append( " OR " ).append( column.getName() );
                condition.append( " ->> '" ).append( jsonArrayColumn.getKey() ).append( "' IS NOT NULL " );
            }
            condition.append( " )" );

            return condition.toString();
        }

        if ( column instanceof JsonColumn ) {
            JsonColumn jsonColumn = JsonColumn.class.cast( column );

            if ( jsonColumn.isLowerCase() ) {
                condition.append( "LOWER( " );
            } else if ( jsonColumn.getType().equals( ColumnType.DATE )
                || jsonColumn.getType().equals( ColumnType.NUMBER ) ) {
                condition.append( "CAST( " );
            }
            condition.append( jsonColumn.getName() );
            condition.append( " ->> " );
            condition.append( "'" ).append( jsonColumn.getKey() ).append( "'" );
            if ( jsonColumn.isLowerCase() ) {
                condition.append( " )" );
            } else if ( jsonColumn.getType().equals( ColumnType.DATE ) ) {
                condition.append( " AS TIMESTAMP )" );
            } else if ( jsonColumn.getType().equals( ColumnType.NUMBER ) ) {
                condition.append( " AS FLOAT )" );
            }
            condition.append( operator.toString() );
            condition.append( jsonColumn.isLowerCase() ? getValue().toLowerCase() : getValue() );

            return condition.toString();
        }

        if ( column.isArray() ) {
            condition.append( column.getName() );

            Set< ? > value = Set.class.cast( this.value );
            condition.append( " @> ARRAY[ " );
            value.forEach( tag -> condition.append(
                column.getType().equals( ColumnType.TEXT ) ? ( "'" + tag + "'" ) : tag ).append( "," )
            );
            condition.deleteCharAt( condition.length() - 1 );
            condition.append( " ]" );
        } else {
            condition.append( column.isLowerCase() ? "LOWER( " + column.getName() + " )" : column.getName() );
            condition.append( operator.toString() );
            condition.append( column.isLowerCase() ? getValue().toLowerCase() : getValue() );
        }

        return condition.toString();
    }

    private String getValue () {
        if ( value == null ) {
            return "";
        }

        if ( column.getType().equals( ColumnType.QUERY ) ) {
            return value.toString();
        }

        switch ( operator ) {
            case LIKE:
            case NOT_LIKE:
                return "'%" + value.toString() + "%'";
            case NULL:
            case NOT_NULL:
                return "";
            case IN:
                Set< Object > values = new HashSet<>();
                if ( value instanceof Set ) {
                    values = Set.class.cast( value );
                } else {
                    values.add( value );
                }
                StringBuilder returnValue = new StringBuilder( "(" );
                values.forEach( item -> {
                    returnValue.append( " " );
                    if ( item instanceof String || item instanceof UUID ) {
                        returnValue.append( "'" ).append( item ).append( "'" );
                    } else {
                        returnValue.append( item );
                    }
                    returnValue.append( "," );
                } );
                returnValue.deleteCharAt( returnValue.length() - 1 );
                returnValue.append( " )" );

                return returnValue.toString();
            case BETWEEN:
                if ( !(value instanceof Map)  ) {
                    return "'" + value.toString() + "'";
                }
                Map<?, ?> mapValue = (Map<?, ?>) value;
                String initialValue = null;
                String finalValue = null;

                boolean hasInitial = mapValue.get("initial") != null &&
                    !StringUtils.isEmpty( mapValue.get("initial").toString() );

                boolean hasFinal = mapValue.get("final") != null &&
                    !StringUtils.isEmpty( mapValue.get("final").toString() );
                if ( hasInitial ) {
                    switch ( column.getType() ) {
                        case DATE:
                            initialValue = "CAST( '" + mapValue.get("initial").toString() + "' AS TIMESTAMP )";
                            break;
                        case NUMBER:
                            initialValue = mapValue.get("initial").toString();
                            break;
                        default:
                            return "";
                    }
                }
                if ( hasFinal ) {
                    switch ( column.getType() ) {
                        case DATE:
                            finalValue = "CAST( '" + mapValue.get("final").toString() + "' AS TIMESTAMP )";
                            break;
                        case NUMBER:
                            finalValue = mapValue.get("final").toString();
                            break;
                        default:
                            return "";
                    }
                }



                if ( hasInitial && hasFinal ) {
                    return " BETWEEN " + initialValue + " AND " + finalValue;
                } else if ( hasInitial ) {
                    return  " >= " + initialValue;
                } else if ( hasFinal ) {
                    return " <= " + finalValue;
                }
            default:
                switch ( column.getType() ) {
                    case DATE:
                        return "CAST( '" + value.toString() + "' AS TIMESTAMP )";
                    case NUMBER:
                        return value.toString();
                    default:
                        return "'" + value.toString() + "'";
                }
        }
    }

    @Override
    public boolean equals ( Object o ) {
        if ( this == o ) return true;
        if ( o == null || getClass() != o.getClass() ) return false;
        Condition condition = ( Condition ) o;
        return Objects.equals( column, condition.column );
    }

    @Override
    public int hashCode () {
        return Objects.hash( column );
    }
}
