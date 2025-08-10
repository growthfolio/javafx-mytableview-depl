package com.example.tablefx;

import java.util.List;

/**
 * Supplies data to the table.
 */
public interface DataProvider<T> {
    DataPage<T> fetch(PageRequest page, List<SortSpec> sort, List<FilterSpec> filters);
}
