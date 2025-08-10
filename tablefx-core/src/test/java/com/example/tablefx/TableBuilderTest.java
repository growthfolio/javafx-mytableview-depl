package com.example.tablefx;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import com.example.tablefx.test.FxTestUtils;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.scene.control.TableView;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class TableBuilderTest {
    @BeforeAll
    static void init() {
        FxTestUtils.launch();
    }

    @Test
    void buildsTableWithColumns() {
        TableView<Person> tv = TableFx.tableOf(Person.class)
            .items(FXCollections.observableArrayList(new Person("Alice", 30)))
            .column(ColumnSpec.of("name", "Name", p -> p.name))
            .column(ColumnSpec.of("age", "Age", p -> p.age.asObject()))
            .build();

        assertEquals(2, tv.getColumns().size());
        assertEquals("Name", tv.getColumns().get(0).getText());
        assertEquals("Alice", tv.getItems().get(0).name.get());
    }

    static class Person {
        final SimpleStringProperty name = new SimpleStringProperty();
        final SimpleIntegerProperty age = new SimpleIntegerProperty();

        Person(String n, int a) {
            name.set(n);
            age.set(a);
        }
    }
}
