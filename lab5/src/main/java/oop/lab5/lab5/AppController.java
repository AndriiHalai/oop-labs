package oop.lab5.lab5;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import oop.lab5.lab5.Shapes.*;

import java.io.IOException;

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
        Editor.draw(new RectShape(Color.ORANGE), canvas);
    }

    public void drawEllipse() {
        Editor.draw(new EllipseShape(), canvas);
    }

    public void drawOLineO() { Editor.draw(new OLineO(), canvas); }

    public void drawCube() {Editor.draw(new Cube(), canvas);}

    public void showTable() throws IOException {
        Table table = Table.getInstance();
        table.show();
    }
}