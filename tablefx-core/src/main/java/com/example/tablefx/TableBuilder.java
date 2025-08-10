package com.example.tablefx;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * Builder for JavaFX {@link TableView} instances.
 */
public class TableBuilder<T> {
    private ObservableList<T> items;
    private final List<TableColumn<T, ?>> columns = new ArrayList<>();

    TableBuilder() {
    }

    public TableBuilder<T> items(ObservableList<T> items) {
        this.items = items;
        return this;
    }

    public TableBuilder<T> column(ColumnSpec<T, ?> spec) {
        columns.add(spec.build());
        return this;
    }

    /**
     * Builds the table view.
     */
    public TableView<T> build() {
        TableView<T> table = new TableView<>();
        if (items != null) {
            table.setItems(items);
        }
        table.getColumns().addAll(columns);
        return table;
    }
}
