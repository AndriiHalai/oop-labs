package oop.lab5.lab5.Shapes;

import javafx.scene.canvas.Canvas;
import oop.lab5.lab5.TableController;

public abstract class Shape {
    public abstract void show(Canvas canvas);

    public abstract void onMousePressed(Canvas canvas);
    public abstract void onMouseDragged(Canvas canvas);
    public abstract void onMouseReleased(Canvas canvas);

    public abstract Shape getInstance();

    public abstract String getName();

    public abstract double getX1();

    public abstract double getY1();

    public abstract double getX2();

    public abstract double getY2();
}
