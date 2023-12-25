package oop.lab6.object2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Server.start();
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("app-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        AppController.setAppController(fxmlLoader.getController());
        stage.setTitle("Object2");
        stage.setScene(scene);
        stage.show();

        stage.setOnCloseRequest(windowEvent -> System.exit(0));
    }

    public static void main(String[] args) {
        launch();
    }
}