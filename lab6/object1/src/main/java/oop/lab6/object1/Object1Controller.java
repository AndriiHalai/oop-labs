package oop.lab6.object1;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

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
                String path = "D:\\homework\\2nd-year\\oop\\oop-labs\\lab6\\object2\\out\\artifacts\\object2_jar\\object2.jar";
                String[] command = {"java", "-jar", path};
                ProcessBuilder processBuilder = new ProcessBuilder(command);
                try {
                    Process p = processBuilder.start();
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

            if (!isActive) {
                String path2 = "D:\\homework\\2nd-year\\oop\\oop-labs\\lab6\\object3\\out\\artifacts\\object3_jar\\object3.jar";
                String[] command2 = {"java", "-jar", path2};
                ProcessBuilder processBuilder2 = new ProcessBuilder(command2);
                try {
                    Process p2 = processBuilder2.start();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                isActive = true;
            }
        });
    }
}