package com.api.calculate.shared.util.query;

public enum Operator {

    EQUAL( " = " ),
    NOT_EQUAL( " <> " ),
    LIKE( " LIKE " ),
    NOT_LIKE( " NOT LIKE " ),
    NULL( " IS NULL " ),
    NOT_NULL( " IS NOT NULL " ),
    IN( " IN " ),
    BETWEEN( "" );

    private final String value;
    Operator ( String value ) {
        this.value = value;
    }

    @Override
    public String toString () {
        return value;
    }
}
