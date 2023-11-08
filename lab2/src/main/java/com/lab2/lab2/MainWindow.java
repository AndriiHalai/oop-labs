package com.lab2.lab2;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainWindow {
    public MainWindow(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainWindow.class.getResource("MainWindow.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        MainWindowController mainWindowController = fxmlLoader.getController();
        stage.setTitle("lab2");
        stage.setScene(scene);
        mainWindowController.setStage(stage);
        stage.show();
    }
}
