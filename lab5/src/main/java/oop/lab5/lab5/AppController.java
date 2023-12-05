package oop.lab5.lab5;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import oop.lab5.lab5.Shapes.*;

import java.io.IOException;

public class AppController {

    private Table table;
    private TableController controller;

    @FXML
    Canvas canvas;

    @FXML
    VBox root;

    @FXML
    private void initialize() throws IOException {
        canvas.widthProperty().bind(root.widthProperty());
        canvas.heightProperty().bind(root.heightProperty());
        canvas.widthProperty().addListener(observable -> Editor.redrawCanvas(canvas));
        canvas.heightProperty().addListener(observable -> Editor.redrawCanvas(canvas));
        table = new Table();
        controller = table.getController();
        drawPoint();
    }

    public void drawPoint() {
        Editor.draw(new PointShape(), canvas, controller);
    }

    public void drawLine() {
        Editor.draw(new LineShape(), canvas, controller);
    }

    public void drawRect() {
        Editor.draw(new RectShape(Color.ORANGE), canvas, controller);
    }

    public void drawEllipse() {
        Editor.draw(new EllipseShape(), canvas, controller);
    }

    public void drawOLineO() { Editor.draw(new OLineO(), canvas, controller); }

    public void drawCube() {Editor.draw(new Cube(), canvas, controller);}

    public void showTable() throws IOException {
        table.show();
    }
}