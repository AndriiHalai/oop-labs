package com.lab1.lab1;

import javafx.fxml.FXML;
import javafx.scene.text.Text;

import java.io.IOException;

public class MainController {
    private boolean isWindowOpened = false;

    @FXML
    private Text userInput;

    public void doFirstTask() {
        if (!isWindowOpened) {
            isWindowOpened = true;
            Action1 action1 = new Action1();
            String selectedItem = action1.userChoice;
            if (selectedItem != null) {
                userInput.setText(selectedItem);
            }
            isWindowOpened = false;
        }
    }
    public void doSecondTask() throws IOException {
        if (!isWindowOpened) {
            isWindowOpened = true;
            Action2 action2 = new Action2();
            String displayedText = action2.input;
            if (!displayedText.isEmpty()) {
                userInput.setText(displayedText);
            }
            isWindowOpened = false;
        }
    }
}
