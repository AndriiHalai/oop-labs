package oop.lab5.lab5;

import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import oop.lab5.lab5.Shapes.Shape;

import java.io.IOException;

public class Table {
    public ObservableList<Shape> shapes;

    public Stage stage;

    public Table() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Table.class.getResource("table.fxml"));
        Parent root = fxmlLoader.load();
        this.stage = new Stage();
        stage.setTitle("Table");
        stage.setScene(new Scene(root));
        TableController.setController(fxmlLoader.getController());
    }

    public void show() throws IOException {
        stage.show();
    }
}
