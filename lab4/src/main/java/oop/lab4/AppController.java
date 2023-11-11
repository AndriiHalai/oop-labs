package oop.lab4;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.VBox;
import oop.lab4.Shapes.EllipseShape;
import oop.lab4.Shapes.LineShape;
import oop.lab4.Shapes.PointShape;
import oop.lab4.Shapes.RectShape;

public class AppController {
    @FXML
    Canvas canvas;

    @FXML
    VBox root;

    @FXML
    private void initialize() {
        canvas.widthProperty().bind(root.widthProperty());
        canvas.heightProperty().bind(root.heightProperty());
        canvas.widthProperty().addListener(observable -> Editor.redrawCanvas(canvas));
        canvas.heightProperty().addListener(observable -> Editor.redrawCanvas(canvas));
        drawPoint();
    }

    public void drawPoint() {
        Editor.draw(new PointShape(), canvas);
    }

    public void drawLine() {
        Editor.draw(new LineShape(), canvas);
    }

    public void drawRect() {
        Editor.draw(new RectShape(), canvas);
    }

    public void drawEllipse() {
        Editor.draw(new EllipseShape(), canvas);
    }
}