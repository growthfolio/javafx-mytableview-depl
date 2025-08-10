package com.example.tablefx;

/**
 * Filter specification for a column.
 */
public class FilterSpec {
    private final String columnId;
    private final Object value;

    public FilterSpec(String columnId, Object value) {
        this.columnId = columnId;
        this.value = value;
    }

    public String getColumnId() {
        return columnId;
    }

    public Object getValue() {
        return value;
    }
}
