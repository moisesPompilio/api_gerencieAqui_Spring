package com.api.calculate.shared.util.query;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.util.CollectionUtils;

public class Select {

    private Table table;
    private boolean isCount;
    private Map< String, String > sumColumns = new HashMap<>();
    private Where where;
    private List< Order > order = new ArrayList<>();
    private List<Column> columns = new ArrayList<>();

    public Select table ( Table table ) {
        this.table = table;
        return this;
    }

    public Select count () {
        this.isCount = true;
        return this;
    }

    public Select sum ( String column, String alias ) {
        this.sumColumns.put( column, alias );
        return this;
    }

    public Select where ( Where where ) {
        this.where = where;
        return this;
    }

    public Select order ( Order order ) {
        this.order.add( order );
        return this;
    }

    public Select order ( List< Order > order ) {
        this.order = order;
        return this;
    }

    public Select addColumns(Column... columns) {
        Collections.addAll(this.columns, columns);
        return this;
    }

    public String toQuery () {
        StringBuilder query = new StringBuilder( "SELECT " );

        if ( isCount ) {
            query.append( "COUNT(*) AS count" );
        } else {
            if (!columns.isEmpty()) {
                query.append(
                    columns.stream()
                        .map(Column::getName)
                        .collect(Collectors.joining(", "))
                );
            } else {
                query.append(table.getAlias() != null ? table.getAlias() + ".*" : "*");
            }
        }
        sumColumns.forEach( ( column, alias ) ->
            query.append( ", SUM( " ).append( column ).append( " ) AS " ).append( alias )
        );
        query.append( " FROM " ).append( table );

        query.append( where != null ? where.toString() : "" );

        if ( !CollectionUtils.isEmpty( order ) && !isCount ) {
            query.append( " ORDER BY " );
            query.append( order.stream().map( Order::toString ).collect( Collectors.joining( ", " ) ) );
        }

        return query.toString();
    }

}
