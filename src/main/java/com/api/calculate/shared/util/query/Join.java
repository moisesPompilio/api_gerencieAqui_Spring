package com.api.calculate.shared.util.query;

import java.util.ArrayList;
import java.util.List;

public class Join {

    private final Table table;
    private final String column1;
    private final String column2;

    private boolean left = false;
    private final List< Condition > conditions = new ArrayList<>();

    public Join ( Table table, String column1, String column2 ) {
        this.table = table;
        this.column1 = column1;
        this.column2 = column2;
    }

    public Join left () {
        this.left = true;
        return this;
    }

    public Join addCondition ( Condition condition ) {
        this.conditions.add( condition );
        return this;
    }

    @Override
    public String toString () {
        StringBuilder join = new StringBuilder(
            ( left ? "LEFT" : "INNER" ) + " JOIN " + table.toString() + " ON " + column1 + " = " + column2
        );

        conditions.forEach( condition -> join.append( " AND " ).append( condition.toString() ) );

        return join.toString();
    }

}
