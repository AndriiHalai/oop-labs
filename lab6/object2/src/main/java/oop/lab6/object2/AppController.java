package oop.lab6.object2;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.List;

public class AppController {

    public static class DoubleData {
        private final double value;
        public DoubleData(double num) {
            this.value = num;
        }

        public double getValue() {
            return this.value;
        }
    }

    public static double min = -1;

    public static double max = 10;

    public static int n = 10;

    @FXML
    private TableView<DoubleData> tableView;

    @FXML
    private TableColumn<DoubleData, Double> valueCol;

    @FXML
    private Button generateButton;

    @FXML
    public void initialize() {
        generateButton.setOnAction(actionEvent -> {
            valueCol.setCellValueFactory(new PropertyValueFactory<>("value"));
            List<DoubleData> vector = generateVector(min, max, n);
            addVectorToTable(vector);
        });
    }

    public void addVectorToTable(List<DoubleData> vector) {
        tableView.getItems().addAll(vector);
    }
    public List<DoubleData> generateVector(double min, double max, int n) {
        List<DoubleData> vector = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            double num = getRandomNumber(min, max);
            vector.add(new DoubleData(num));
        }
        return vector;
    }

    public double getRandomNumber(double min, double max) {
        double num = Math.random() * (max - min) + min;
        return Math.floor(num * 100) / 100;
    }
}