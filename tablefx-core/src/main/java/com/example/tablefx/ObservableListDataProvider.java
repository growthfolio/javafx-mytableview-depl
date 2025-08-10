package com.example.tablefx;

import java.util.List;

import javafx.collections.ObservableList;

/**
 * Simple {@link DataProvider} backed by an {@link ObservableList}.
 */
public class ObservableListDataProvider<T> implements DataProvider<T> {
    private final ObservableList<T> source;

    public ObservableListDataProvider(ObservableList<T> source) {
        this.source = source;
    }

    @Override
    public DataPage<T> fetch(PageRequest page, List<SortSpec> sort, List<FilterSpec> filters) {
        int from = Math.min(page.getPageNumber() * page.getPageSize(), source.size());
        int to = Math.min(from + page.getPageSize(), source.size());
        return new DataPage<>(source.subList(from, to), source.size());
    }
}
