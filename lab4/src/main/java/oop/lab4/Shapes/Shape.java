package oop.lab4.Shapes;

import javafx.scene.canvas.Canvas;

import java.util.ArrayList;

public abstract class Shape {
    public abstract void show(Canvas canvas);

    public abstract void onMousePressed(Canvas canvas);
    public abstract void onMouseDragged(Canvas canvas);
    public abstract void onMouseReleased(Canvas canvas);
}
