package oop.lab5.lab5;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import oop.lab5.lab5.Shapes.Shape;
import oop.lab5.lab5.Shapes.Test;

public class TableController {

    public ObservableList<Shape> shapes;

    public static TableController controller;

    @FXML
    public TableView<Shape> tableView;

    @FXML
    private AnchorPane root;

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

    public void show() {
        Stage window = new Stage();
        Scene scene = new Scene(root, 700, 400);
        Test test = new Test("Test", 1,1,1,1);
        tableView.getItems().add(test);

        window.setScene(scene);
        window.show();
    }

    public void add(Shape shape) {
        tableView.getItems().add(shape);
    }

    public static void setController(TableController val) {
        controller = val;
    }
}
