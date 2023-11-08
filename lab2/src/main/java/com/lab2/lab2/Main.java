package com.lab2.lab2;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        MainWindow mainWindow = new MainWindow(stage);
    }

    public static void main(String[] args) {
        launch();
    }
}
