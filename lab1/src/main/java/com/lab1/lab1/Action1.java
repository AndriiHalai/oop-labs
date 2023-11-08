package com.lab1.lab1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Action1 {
    public String userChoice;

    public Action1() {
        Stage window = new Stage();
        window.setTitle("Action1");

        VBox root = new VBox();
        root.setPadding(new Insets(10));
        root.setSpacing(4);

        ListView<String> list = new ListView<>();
        list.setPrefSize(100, 100);
        ObservableList<String> groups = FXCollections.observableArrayList(
                "ІМ-21", "ІМ-22", "ІМ-23", "ІМ-24",
                "ІП-21", "ІП-22", "ІП-23", "ІП-24");

        list.setItems(groups);

        Button okBtn = new Button("Так");
        Button cancelBtn = new Button("Відміна");

        okBtn.setOnAction(actionEvent -> {
            userChoice = list.getSelectionModel().getSelectedItem();
            window.close();
        });

        cancelBtn.setOnAction(actionEvent -> window.close());

        HBox hBox = new HBox();
        hBox.setSpacing(4);
        hBox.getChildren().addAll(okBtn, cancelBtn);

        root.getChildren().addAll(list, hBox);

        Scene scene = new Scene(root, 300, 275);
        window.setScene(scene);
        window.showAndWait();
    }
}
