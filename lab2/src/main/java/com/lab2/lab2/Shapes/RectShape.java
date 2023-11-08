package com.lab2.lab2.Shapes;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class RectShape extends Shape{
    double x1;
    double y1;
    double w;
    double h;

    public RectShape(double x1, double y1, double w, double h) {
        this.x1 = x1;
        this.y1 = y1;
        this.w = w;
        this.h = h;
    }

    public void show(Canvas canvas) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setLineDashes(0);
        gc.strokeRect(x1, y1, w, h);
    }
}
