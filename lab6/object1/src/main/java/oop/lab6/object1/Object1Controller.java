package oop.lab6.object1;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Object1Controller {
    private boolean isActive = false;

    @FXML
    private Button startButton;

    @FXML
    private TextField nField;

    @FXML
    private TextField minField;

    @FXML
    private TextField maxField;

    @FXML
    public void initialize() {
        startButton.setOnAction(actionEvent -> {
            if (!isActive) {
                String path = "./out/artifacts/object1_jar/object2.jar";
                String[] command = {"java", "-jar", path};
                ProcessBuilder processBuilder = new ProcessBuilder(command);
                String path2 = "./out/artifacts/object1_jar/object3.jar";
                String[] command2 = {"java", "-jar", path2};
                ProcessBuilder processBuilder2 = new ProcessBuilder(command2);
                try {
                    Process p = processBuilder.start();
                    Process p2 = processBuilder2.start();
                    Thread.sleep(1000);
                } catch (IOException | InterruptedException e) {
                    throw new RuntimeException(e);
                }
                isActive = true;
            }
            try {
                Client.send(nField.getText(), minField.getText(), maxField.getText());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}