package com.lab1.lab1;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Action2 {
    public String input = "";

    public Action2() {
        Stage window = new Stage();
        window.setTitle("Action2");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(5, 5, 5, 5));

        Label label = new Label("Enter text:");
        grid.add(label, 0, 0);

        TextField textField = new TextField();
        grid.add(textField, 1, 0);

        Button okBtn = new Button("Так");
        HBox hbOkBtn = new HBox(10);
        hbOkBtn.setAlignment(Pos.BOTTOM_LEFT);
        hbOkBtn.getChildren().add(okBtn);
        grid.add(hbOkBtn, 0, 1);

        Button cancelBtn = new Button("Відміна");
        HBox hbCancelBtn = new HBox(10);
        hbCancelBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbCancelBtn.getChildren().add(cancelBtn);
        grid.add(hbCancelBtn, 1, 1);

        okBtn.setOnAction(actionEvent -> {
            input = textField.getText();
            window.close();
        });

        cancelBtn.setOnAction(actionEvent -> window.close());

        Scene scene = new Scene(grid, 300, 275);
        window.setScene(scene);
        window.showAndWait();
    }
}
