package oop.lab5.lab5;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import oop.lab5.lab5.Shapes.Shape;

import java.io.IOException;

public class Table {

    public Stage stage;

    private final TableController controller;

    private Table() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Table.class.getResource("table.fxml"));
        Parent root = fxmlLoader.load();
        this.stage = new Stage();
        stage.setTitle("Table");
        stage.setScene(new Scene(root));
        controller = fxmlLoader.getController();
        TableController.setController(fxmlLoader.getController());
    }

    private static class TableHolder {
        public static final Table INSTANCE;

        static {
            try {
                INSTANCE = new Table();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static Table getInstance() {
        return TableHolder.INSTANCE;
    }

    public void show() throws IOException {
        stage.show();
    }

    public void addToTable(Shape shape) {
        controller.add(shape);
    }

    public TableController getController() {
        return controller;
    }
}
