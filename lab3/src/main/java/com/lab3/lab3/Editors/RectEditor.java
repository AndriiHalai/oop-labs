package com.lab3.lab3.Editors;

import com.lab3.lab3.Shapes.RectShape;
import com.lab3.lab3.Shapes.Shape;
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

    public void removeMouseEventHandlers(Canvas canvas) {
        canvas.setOnMouseClicked(null);
        canvas.setOnMousePressed(null);
        canvas.setOnMouseDragged(null);
        canvas.setOnMouseReleased(null);
    }

    @Override
    protected void onMousePressed(Canvas canvas) {
        canvas.setOnMousePressed(mouseEvent -> {
            x1 = mouseEvent.getX();
            y1 = mouseEvent.getY();
        });
    }

    @Override
    protected void onMouseDragged(Canvas canvas) {
        canvas.setOnMouseDragged(mouseEvent -> {
            clearCanvas(canvas);
            Shape.redrawCanvas(canvas);

            GraphicsContext gc = canvas.getGraphicsContext2D();
            double topLeftX;
            double topLeftY;
            x2 = mouseEvent.getX();
            y2 = mouseEvent.getY();
            width = Math.abs(x1 - x2);
            height = Math.abs(y1 - y2);

            if (x1 <= x2 && y1 <= y2) { // BOTTOM RIGHT
                topLeftX = x1;
                topLeftY = y1;
            } else if (x1 >= x2 && y1 <= y2) { // BOTTOM LEFT
                topLeftX = x1 - Math.abs(x1 - x2);
                topLeftY = y2 - Math.abs(y1 - y2);
            } else if (x1 <= x2 && y1 >= y2) { // TOP RIGHT
                topLeftX = x1;
                topLeftY = y1 - Math.abs(y1 - y2);
            } else { // TOP LEFT
                topLeftX = x2;
                topLeftY = y2;
            }

            x = topLeftX;
            y = topLeftY;
            gc.strokeRect(topLeftX, topLeftY, width, height);
        });
    }

    @Override
    protected void onMouseReleased(Canvas canvas) {
        canvas.setOnMouseReleased(mouseEvent -> {
            clearCanvas(canvas);
            Shape.redrawCanvas(canvas);
            RectShape rect = new RectShape(x, y, width, height);
            rect.show(canvas);
            Shape.addShape(rect);
        });
    }
}

