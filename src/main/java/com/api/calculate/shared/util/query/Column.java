package com.api.calculate.shared.util.query;

import java.util.Objects;

public class Column {

    private final String name;
    private final ColumnType type;

    private boolean isLowerCase = false;
    private boolean isArray = false;

    public Column ( String name, ColumnType type ) {
        this.name = name;
        this.type = type;
    }

    public Column lowerCase () {
        this.isLowerCase = true;
        return this;
    }

    public Column array () {
        this.isArray = true;
        return this;
    }

    public String getName () {
        return name;
    }

    public ColumnType getType () {
        return type;
    }

    public boolean isLowerCase () {
        return isLowerCase;
    }

    public boolean isArray () {
        return isArray;
    }

    @Override
    public boolean equals ( Object o ) {
        if ( this == o ) return true;
        if ( !( o instanceof Column ) ) return false;
        Column column = ( Column ) o;
        return Objects.equals( getName(), column.getName() );
    }

    @Override
    public int hashCode () {
        return Objects.hash( getName() );
    }
}
