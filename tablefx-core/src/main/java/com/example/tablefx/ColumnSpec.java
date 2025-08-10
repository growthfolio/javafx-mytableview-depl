package com.example.tablefx;

import java.util.function.Function;

import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableColumn;

/**
 * Specification of a table column.
 *
 * @param <T> row type
 * @param <R> cell value type
 */
public class ColumnSpec<T, R> {
    private final String id;
    private final String title;
    private final Function<T, ObservableValue<R>> valueProvider;
    private boolean sortable = true;
    private boolean resizable = true;
    private boolean editable = false;

    private ColumnSpec(String id, String title, Function<T, ObservableValue<R>> valueProvider) {
        this.id = id;
        this.title = title;
        this.valueProvider = valueProvider;
    }

    public static <T, R> ColumnSpec<T, R> of(String id, String title, Function<T, ObservableValue<R>> valueProvider) {
        return new ColumnSpec<>(id, title, valueProvider);
    }

    public ColumnSpec<T, R> sortable(boolean sortable) {
        this.sortable = sortable;
        return this;
    }

    public ColumnSpec<T, R> resizable(boolean resizable) {
        this.resizable = resizable;
        return this;
    }

    public ColumnSpec<T, R> editable(boolean editable) {
        this.editable = editable;
        return this;
    }

    /**
     * Builds a JavaFX {@link TableColumn} using the specification.
     */
    public TableColumn<T, R> build() {
        TableColumn<T, R> col = new TableColumn<>(title);
        col.setId(id);
        col.setSortable(sortable);
        col.setResizable(resizable);
        col.setEditable(editable);
        col.setCellValueFactory(cellData -> valueProvider.apply(cellData.getValue()));
        return col;
    }
}
