package com.lab2.lab2.Editors;

import com.lab2.lab2.Shapes.RectShape;
import com.lab2.lab2.Shapes.Shape;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class RectEditor extends ShapeEditor {
    private double x, y, x1, y1, x2, y2, width, height;
    public void drawShape(Canvas canvas) {
        removeMouseEventHandlers(canvas);
        onMousePressed(canvas);
        onMouseDragged(canvas);
        onMouseReleased(canvas);
    }
    public void clearCanvas(Canvas canvas) {
        canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

    @Override
    protected void onMousePressed(Canvas canvas) {
        canvas.setOnMousePressed(mouseEvent -> {
            x = mouseEvent.getX();
            y = mouseEvent.getY();
        });
    }

    public void removeMouseEventHandlers(Canvas canvas) {
        canvas.setOnMouseClicked(null);
        canvas.setOnMousePressed(null);
        canvas.setOnMouseDragged(null);
        canvas.setOnMouseReleased(null);
    }

    @Override
    protected void onMouseDragged(Canvas canvas) {
        canvas.setOnMouseDragged(mouseEvent -> {
            clearCanvas(canvas);
            Shape.redrawCanvas(canvas);
            GraphicsContext gc = canvas.getGraphicsContext2D();
            x2 = mouseEvent.getX();
            y2 = mouseEvent.getY();
            gc.setLineDashes(3);
            if (y2 >= y && x2 >= x) { // BOTTOM RIGHT
                x1 = x - Math.abs(x2 - x);
                y1 = y - Math.abs(y2 - y);
                width = Math.abs(x2 - x1);
                height = Math.abs(y2 - y1);
            } else if (y2 >= y && x2 <= x) { // BOTTOM LEFT
                x1 = x - Math.abs(x2 - x);
                y1 = y - Math.abs(y2 - y);
                width = x + Math.abs(x2 - x) - x1;
                height = y2 - y1;
            } else if (y2 <= y && x2 <= x) { // TOP LEFT
                x1 = x2;
                y1 = y2;
                x2 = x + Math.abs(x2 - x);
                y2 = y + Math.abs(y2 - y);
                width = Math.abs(x2 - x1);
                height = Math.abs(y2 - y1);
            } else if (y2 <= y && x2 >= x) { // TOP RIGHT
                x1 = x - Math.abs(x2 - x);
                y1 = y - Math.abs(y2 - y);
                width = Math.abs(x2 - x1);
                height = 2 * Math.abs(y - y1);
            }
            gc.strokeRect(x1, y1, width, height);
        });
    }

    @Override
    protected void onMouseReleased(Canvas canvas) {
        canvas.setOnMouseReleased(mouseEvent -> {
            clearCanvas(canvas);
            Shape.redrawCanvas(canvas);
            RectShape rect = new RectShape(x1, y1, width, height);
            rect.show(canvas);
            Shape.addShape(rect);
        });
    }
}
