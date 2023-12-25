package oop.lab6.object2;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.List;

public class AppController {
    private static AppController appController;
    public static class DoubleData {
        private final double value;
        public DoubleData(double num) {
            this.value = num;
        }

        public double getValue() {
            return this.value;
        }
    }
    public static int n;

    public static double min;

    public static double max;


    @FXML
    private TableView<DoubleData> tableView;

    @FXML
    private TableColumn<DoubleData, Double> valueCol;

    @FXML
    public void initialize() {
        valueCol.setCellValueFactory(new PropertyValueFactory<>("value"));
    }

    public void addVectorToTable(List<DoubleData> vector) {
        if (tableView.getItems() != null) {
            tableView.getItems().clear();
        }
        tableView.getItems().addAll(vector);
    }
    public static void generateVector() {
        List<DoubleData> vector = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            double num = getRandomNumber(min, max);
            vector.add(new DoubleData(num));
        }
        AppController controller = AppController.getAppController();
        controller.addVectorToTable(vector);
    }

    public static double getRandomNumber(double min, double max) {
        double num = Math.random() * (max - min) + min;
        return Math.floor(num * 100) / 100;
    }

    public static void setAppController(AppController appController) {
        AppController.appController = appController;
    }

    public static AppController getAppController() {
        return AppController.appController;
    }
}