package oop.lab5.lab5;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Table {

    public Stage stage;

    private final TableController controller;

    public Table() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Table.class.getResource("table.fxml"));
        Parent root = fxmlLoader.load();
        this.stage = new Stage();
        stage.setTitle("Table");
        stage.setScene(new Scene(root));
        controller = fxmlLoader.getController();
        TableController.setController(fxmlLoader.getController());
    }

    public void show() throws IOException {
        stage.show();
    }

    public TableController getController() {
        return controller;
    }
}
