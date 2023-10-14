package com.api.calculate.shared.util.query;

public class JsonArrayColumn extends JsonColumn {

    private final String itemKey;

    public JsonArrayColumn ( String name, ColumnType type, String key, String itemKey ) {
        super( name, type, key );
        this.itemKey = itemKey;
    }

    public JsonArrayColumn ( String name, ColumnType type, String key ) {
        this( name, type, key, "" );
    }

    public String getItemKey () {
        return itemKey;
    }
}
