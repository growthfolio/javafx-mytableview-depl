package com.example.tablefx;

import java.util.List;

/**
 * A page of data returned by a {@link DataProvider}.
 */
public class DataPage<T> {
    private final List<T> items;
    private final long totalCount;

    public DataPage(List<T> items, long totalCount) {
        this.items = List.copyOf(items);
        this.totalCount = totalCount;
    }

    public List<T> getItems() {
        return items;
    }

    public long getTotalCount() {
        return totalCount;
    }
}
