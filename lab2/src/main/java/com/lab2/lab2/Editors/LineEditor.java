package com.lab2.lab2.Editors;

import com.lab2.lab2.Shapes.LineShape;
import com.lab2.lab2.Shapes.Shape;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class LineEditor extends ShapeEditor {
    private double x1, y1, x2, y2;
    public void drawShape(Canvas canvas) {
        removeMouseEventHandlers(canvas);
        onMousePressed(canvas);
        onMouseDragged(canvas);
        onMouseReleased(canvas);
    }

    public void clearCanvas(Canvas canvas) {
        canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

    public void removeMouseEventHandlers(Canvas canvas) {
        canvas.setOnMouseClicked(null);
        canvas.setOnMousePressed(null);
        canvas.setOnMouseDragged(null);
        canvas.setOnMouseReleased(null);
    }

    @Override
    protected void onMousePressed(Canvas canvas) {
        canvas.setOnMousePressed(mouseEvent -> {
            this.x1 = mouseEvent.getX();
            this.y1 = mouseEvent.getY();
        });
    }

    @Override
    protected void onMouseDragged(Canvas canvas) {
        canvas.setOnMouseDragged(mouseEvent -> {
            clearCanvas(canvas);
            Shape.redrawCanvas(canvas);
            this.x2 = mouseEvent.getX();
            this.y2 = mouseEvent.getY();
            GraphicsContext gc = canvas.getGraphicsContext2D();
            gc.setFill(Color.BLACK);
            gc.setLineDashes(3);
            gc.strokeLine(this.x1, this.y1, this.x2, this.y2);
        });
    }

    @Override
    protected void onMouseReleased(Canvas canvas) {
        canvas.setOnMouseReleased(mouseEvent -> {
            clearCanvas(canvas);
            Shape.redrawCanvas(canvas);
            this.x2 = mouseEvent.getX();
            this.y2 = mouseEvent.getY();
            LineShape line = new LineShape(this.x1, this.y1, this.x2, this.y2);
            line.show(canvas);
            Shape.addShape(line);
        });
    }
}
