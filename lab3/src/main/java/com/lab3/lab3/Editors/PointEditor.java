package com.lab3.lab3.Editors;

import com.lab3.lab3.Shapes.PointShape;
import com.lab3.lab3.Shapes.Shape;
import javafx.scene.canvas.Canvas;

public class PointEditor extends ShapeEditor {
    private double x, y;
    public void drawShape(Canvas canvas) {
        removeMouseEventHandlers(canvas);
        onMousePressed(canvas);
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
            this.x = mouseEvent.getX();
            this.y = mouseEvent.getY();
            PointShape point = new PointShape(x, y);
            point.show(canvas);
            Shape.SHAPE_ARRAY_LIST.add(point);
        });
    }

    @Override
    protected void onMouseDragged(Canvas canvas) {

    }

    @Override
    protected void onMouseReleased(Canvas canvas) {

    }
}
