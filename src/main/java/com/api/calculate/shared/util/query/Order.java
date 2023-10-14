package com.api.calculate.shared.util.query;

public class Order {

    private final String column;
    private final OrderType type;

    public Order ( String column ) {
        this( column, null );
    }

    public Order ( String column, OrderType type ) {
        this.column = column;
        this.type = type == null ? OrderType.ASC : type;
    }

    public String getBy () {
        return column;
    }

    public OrderType getType () {
        return type;
    }

    @Override
    public String toString () {
        return column + " " + type.toString() + " NULLS LAST";
    }

}
