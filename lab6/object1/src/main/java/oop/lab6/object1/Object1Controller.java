package oop.lab6.object1;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class Object1Controller {
    @FXML
    private Button startButton;

    @FXML
    public void initialize() {
        startButton.setOnAction(actionEvent -> {
            String path = "D:\\homework\\2nd-year\\oop\\oop-labs\\lab6\\object2\\out\\artifacts\\object2_jar\\object2.jar";
            String[] command = {"java", "-jar", path};
            ProcessBuilder processBuilder = new ProcessBuilder(command);
            try {
                Process p = processBuilder.start();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

}