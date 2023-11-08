package com.lab3.lab3.Shapes;

import javafx.scene.canvas.Canvas;

import java.util.ArrayList;

public abstract class Shape {
    public static final ArrayList<Shape> SHAPE_ARRAY_LIST = new ArrayList<>();
    public static void addShape(Shape shape) {
        SHAPE_ARRAY_LIST.add(shape);
    }
    public static void redrawCanvas(Canvas canvas) {
        for (Shape shape : SHAPE_ARRAY_LIST) {
            shape.show(canvas);
        }
    }

    protected abstract void show(Canvas canvas);
}
