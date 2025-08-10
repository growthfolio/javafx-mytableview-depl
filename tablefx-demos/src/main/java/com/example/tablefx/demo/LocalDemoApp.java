package com.example.tablefx.demo;

import com.example.tablefx.ColumnSpec;
import com.example.tablefx.TableFx;
import javafx.application.Application;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

/**
 * Simple demo application showcasing TableFx.
 */
public class LocalDemoApp extends Application {
    @Override
    public void start(Stage stage) {
        TableView<Person> table = TableFx.tableOf(Person.class)
            .items(FXCollections.observableArrayList(new Person("Alice", 30), new Person("Bob", 22)))
            .column(ColumnSpec.of("name", "Name", p -> p.name))
            .column(ColumnSpec.of("age", "Age", p -> p.age.asObject()))
            .build();
        stage.setScene(new Scene(table, 400, 300));
        stage.setTitle("TableFx Demo");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static class Person {
        public final SimpleStringProperty name = new SimpleStringProperty();
        public final SimpleIntegerProperty age = new SimpleIntegerProperty();

        public Person(String n, int a) {
            name.set(n);
            age.set(a);
        }
    }
}
