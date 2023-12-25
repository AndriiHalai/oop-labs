package oop.lab6.object3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.io.IOException;

public class Object3 extends Application {
    public static LineChart<Number, Number> graph;

    @Override
    public void start(Stage stage) throws IOException {
        Server.start();
        FXMLLoader fxmlLoader = new FXMLLoader(Object3.class.getResource("graph.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Object3Controller.setObject3Controller(fxmlLoader.getController());
        stage.setTitle("Object3");
        stage.setScene(scene);
        stage.show();

//        XYChart.Series<Number, Number> series = new XYChart.Series<>();
//        series.getData().add(new XYChart.Data<>(1, 5));
//        series.getData().add(new XYChart.Data<>(2, 10));
//        series.getData().add(new XYChart.Data<>(3, 15));
        stage.setOnCloseRequest(windowEvent -> System.exit(0));
    }

    public static void updateGraph(XYChart.Series<Number, Number> vector) {
        if (graph.getData() == null) {
            graph.getData().clear();
        }
        graph.getData().add(vector);
    }

    public static void main(String[] args) {
        launch();
    }
}