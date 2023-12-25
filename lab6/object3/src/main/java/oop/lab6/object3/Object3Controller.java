package oop.lab6.object3;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class Object3Controller {
    private static Object3Controller object3Controller;

    @FXML
    private LineChart<Number, Number> lineChart;

//    @FXML
//    public void initialize() {
//        XYChart.Series<Number, Number> series = new XYChart.Series<>();
//        series.getData().add(new XYChart.Data<>(1, 5.8));
//        series.getData().add(new XYChart.Data<>(15.4, 30));
//        series.getData().add(new XYChart.Data<>(50, 80));
//        lineChart.getData().add(series);
//    }

    public static void draw(XYChart.Series<Number, Number> vector) {
        Object3Controller controller = Object3Controller.getObject3Controller();
        controller.updateGraph(vector);
    }

    public void updateGraph(XYChart.Series<Number, Number> vector) {
        if (lineChart.getData() != null) {
            lineChart.getData().clear();
        }
        lineChart.getData().addAll(vector);
    }

    public static Object3Controller getObject3Controller() {
        return Object3Controller.object3Controller;
    }

    public static void setObject3Controller(Object3Controller controller) {
        Object3Controller.object3Controller = controller;
    }
}
