package com.lab3.lab3.Shapes;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

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
        gc.setFill(Color.ORANGE);
        gc.fillRect(x1, y1, w , h);
        gc.strokeRect(x1, y1, w, h);
    }
}
