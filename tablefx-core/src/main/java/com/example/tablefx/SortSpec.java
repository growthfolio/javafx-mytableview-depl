package com.example.tablefx;

/**
 * Sort specification for a column.
 */
public class SortSpec {
    private final String columnId;
    private final boolean ascending;

    public SortSpec(String columnId, boolean ascending) {
        this.columnId = columnId;
        this.ascending = ascending;
    }

    public String getColumnId() {
        return columnId;
    }

    public boolean isAscending() {
        return ascending;
    }
}
