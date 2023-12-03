package oop.lab5.lab5;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Table {
    private Table() {}

    private static class TableHolder {
        static final Table INSTANCE = new Table();
    }

    public void show() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("table.fxml"));
        Parent root = fxmlLoader.load();
        Stage window = new Stage();
        window.setTitle("Table");
        window.setScene(new Scene(root));
        window.show();
    }

    public static Table getInstance() {
        return TableHolder.INSTANCE;
    }
}
