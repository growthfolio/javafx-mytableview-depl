package com.example.tablefx;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.IntStream;

import javafx.collections.FXCollections;
import org.junit.jupiter.api.Test;

class ObservableListDataProviderTest {
    @Test
    void fetchReturnsPage() {
        var list = FXCollections.observableArrayList(IntStream.rangeClosed(1, 100).boxed().toList());
        ObservableListDataProvider<Integer> provider = new ObservableListDataProvider<>(list);
        DataPage<Integer> page = provider.fetch(new PageRequest(1, 10), List.of(), List.of());
        assertEquals(100, page.getTotalCount());
        assertEquals(10, page.getItems().size());
        assertEquals(11, page.getItems().get(0));
    }
}
