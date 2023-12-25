package oop.lab6.object3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Object3 extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Server.start();
        FXMLLoader fxmlLoader = new FXMLLoader(Object3.class.getResource("graph.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Object3Controller.setObject3Controller(fxmlLoader.getController());
        stage.setTitle("Object3");
        stage.setScene(scene);
        stage.show();

        stage.setOnCloseRequest(windowEvent -> System.exit(0));
    }

    public static void main(String[] args) {
        launch();
    }
}