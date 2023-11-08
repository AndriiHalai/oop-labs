package com.lab3.lab3;

import com.lab3.lab3.Editors.EllipseEditor;
import com.lab3.lab3.Editors.LineEditor;
import com.lab3.lab3.Editors.PointEditor;
import com.lab3.lab3.Editors.RectEditor;
import com.lab3.lab3.Shapes.Shape;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.VBox;

public class MainWindowController {
    @FXML
    Canvas canvas;

    @FXML
    VBox root;

    @FXML
    RadioMenuItem pointOption, lineOption, rectOption, ellipseOption;

    @FXML
    ToggleButton pointTool, lineTool, rectTool, ellipseTool;

    @FXML
    private void initialize() {
        canvas.widthProperty().bind(root.widthProperty());
        canvas.heightProperty().bind(root.heightProperty());
        canvas.widthProperty().addListener(observable -> Shape.redrawCanvas(canvas));
        canvas.heightProperty().addListener(observable -> Shape.redrawCanvas(canvas));
        drawPoint();
    }

    public void drawPoint() {
        PointEditor pointEditor = new PointEditor();
        pointEditor.drawShape(canvas);
        setHighlight(pointOption, pointTool);
    }

    public void drawLine() {
        LineEditor lineEditor = new LineEditor();
        lineEditor.drawShape(canvas);
        setHighlight(lineOption, lineTool);
    }

    public void drawRectangle() {
        RectEditor rectEditor = new RectEditor();
        rectEditor.drawShape(canvas);
        setHighlight(rectOption, rectTool);
    }

    public void drawEllipse() {
        EllipseEditor ellipseEditor = new EllipseEditor();
        ellipseEditor.drawShape(canvas);
        setHighlight(ellipseOption, ellipseTool);
    }

    private void setHighlight(RadioMenuItem option, ToggleButton tool) {
        option.setSelected(true);
        tool.setSelected(true);
        tool.requestFocus();
    }
}
