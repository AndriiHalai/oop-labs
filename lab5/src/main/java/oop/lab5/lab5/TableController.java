package oop.lab5.lab5;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import oop.lab5.lab5.Shapes.Shape;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class TableController {

    private static TableController controller;

    private final List<Shape> SHAPES_LIST = new ArrayList<>();

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
        tableView.getItems().addAll(SHAPES_LIST);
    }

    public void add(Shape shape) {
        SHAPES_LIST.add(shape);
        tableView.getItems().add(shape);
    }

    public void saveToFile() {
        try {
           FileWriter fw = new FileWriter("D:/homework/2nd-year/oop/oop-labs/lab5/src/main/java/oop/lab5/lab5/shapes.txt");
           fw.write("Shape_Name \t" + "x1\t" + "x2\t" + "x3\t" + "x4\t\n");
           for (Shape shape : SHAPES_LIST) {
               fw.write(shape.getName() + "\t"
                       + Math.round(shape.getX1()) + "\t"
                       + Math.round(shape.getY1()) + "\t"
                       + Math.round(shape.getX2()) + "\t"
                       + Math.round(shape.getY2()) );
               fw.write("\n");
           }
           fw.close();
        } catch (Exception e) {
            e.getStackTrace();
        }

    }

    public static void setController(TableController val) {
        controller = val;
    }

    public static TableController getController() {
        return controller;
    }
}
