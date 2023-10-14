package com.api.calculate.shared.util.query;

import java.util.HashSet;
import java.util.Set;

public class Table {

    private final String name;

    private String alias;

    private Set< Join > joins = new HashSet<>();

    public Table ( String name ) {
        this.name = name;
    }

    public Table ( String name, String alias ) {
        this.name = name;
        this.alias = alias;
    }

    public Table join ( Join join ) {
        this.joins.add( join );
        return this;
    }

    public Column getColumn(String columnName, ColumnType columnType) {
        return new Column(alias + "." + columnName, columnType);
    }

    @Override
    public String toString () {
        StringBuilder str = new StringBuilder( name );
        if ( alias != null ) {
            str.append( " AS " ).append( alias );
        }

        joins.forEach( join -> str.append( " " ).append( join.toString() ) );

        return str.toString();
    }

    protected String getName () {
        return name;
    }

    protected String getAlias () {
        return alias;
    }

}
