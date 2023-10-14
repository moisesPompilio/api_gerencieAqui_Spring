package com.api.calculate.shared.util.query;

import java.util.Objects;

public class JsonColumn extends Column {

    private final String key;

    public JsonColumn ( String name, ColumnType type, String key ) {
        super( name, type );
        this.key = key;
    }

    public String getKey () {
        return key;
    }

    @Override
    public boolean equals ( Object o ) {
        if ( this == o ) {
            return true;
        }
        if ( o == null || getClass() != o.getClass() ) {
            return false;
        }
        if ( !super.equals( o ) ) {
            return false;
        }
        JsonColumn that = ( JsonColumn ) o;
        return Objects.equals( getName(), that.getName() ) && Objects.equals( key, that.key );
    }

    @Override
    public int hashCode () {
        return Objects.hash( super.hashCode(), key );
    }
}
