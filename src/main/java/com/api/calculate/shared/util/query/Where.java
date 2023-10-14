package com.api.calculate.shared.util.query;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Where {

    private List< Condition > conditions = new ArrayList<>();

    public Where add ( Condition condition ) {
        this.conditions.add( condition );
        return this;
    }

    @Override
    public String toString () {
        StringBuilder where = new StringBuilder( " WHERE " );
        Map< Condition, List< Condition > > conditions = this.conditions
            .stream()
            .collect( Collectors.groupingBy( Function.identity() ) );
        boolean first = true;
        for ( Map.Entry< Condition, List< Condition > > item : conditions.entrySet() ) {
            String query = item.getValue().stream().map( Object::toString ).collect( Collectors.joining( " OR " ) );
            where.append( !first ? " AND ( " : "( " ).append( query ).append( " )" );
            first = false;
        }
        return where.toString();
    }
}
