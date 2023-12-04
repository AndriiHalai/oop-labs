package oop.lab5.lab5;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import oop.lab5.lab5.Shapes.Shape;

public class TableController {

    private static TableController controller;

    @FXML
    public TableView<Shape> tableView;

    @FXML
    private TableColumn<Shape, String> nameCol;

    @FXML
    private TableColumn<Shape, Integer> x1Col;

    @FXML
    private TableColumn<Shape, Integer> y1Col;

    @FXML
    private TableColumn<Shape, Integer> x2Col;

    @FXML
    private TableColumn<Shape, Integer> y2Col;

    @FXML
    public void initialize() {
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        x1Col.setCellValueFactory(new PropertyValueFactory<>("x1"));
        y1Col.setCellValueFactory(new PropertyValueFactory<>("y1"));
        x2Col.setCellValueFactory(new PropertyValueFactory<>("x2"));
        y2Col.setCellValueFactory(new PropertyValueFactory<>("y2"));
    }

    public void add(Shape shape) {
        tableView.getItems().add(shape);
    }

    public static void setController(TableController val) {
        controller = val;
    }

    public static TableController getController() {
        return controller;
    }
}
