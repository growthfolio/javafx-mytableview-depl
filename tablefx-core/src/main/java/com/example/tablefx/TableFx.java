package com.example.tablefx;

/**
 * Entry point for building tables.
 */
public final class TableFx {
    private TableFx() {
    }

    public static <T> TableBuilder<T> tableOf(Class<T> type) {
        return new TableBuilder<>();
    }
}
