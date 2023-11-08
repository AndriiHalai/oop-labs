package com.lab2.lab2;

import com.lab2.lab2.Editors.EllipseEditor;
import com.lab2.lab2.Editors.LineEditor;
import com.lab2.lab2.Editors.PointEditor;
import com.lab2.lab2.Editors.RectEditor;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;

public class MainWindowController {
    @FXML
    Canvas canvas;
    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }
    public void drawPoint() {
        setStageTitle("Крапка");
        PointEditor pointEditor = new PointEditor();
        pointEditor.drawShape(canvas);
    }

    public void drawLine() {
        setStageTitle("Лінія");
        LineEditor lineEditor = new LineEditor();
        lineEditor.drawShape(canvas);
    }

    public void drawRectangle() {
        setStageTitle("Прямокутник");
        RectEditor rectEditor = new RectEditor();
        rectEditor.drawShape(canvas);
    }

    public void drawEllipse() {
        setStageTitle("Еліпс");
        EllipseEditor ellipseEditor = new EllipseEditor();
        ellipseEditor.drawShape(canvas);
    }


    public void setStageTitle(String title) {
        stage.setTitle(title);
    }
}
