package com.lab1.lab1;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class MyProgram extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        MainScene mainScene = new MainScene(stage);
    }

    public static void main(String[] args) {
        launch();
    }
}
