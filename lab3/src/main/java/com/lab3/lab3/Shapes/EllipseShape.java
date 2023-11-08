package com.lab3.lab3.Shapes;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class EllipseShape extends Shape {
    double x;
    double y;
    double width;
    double height;

    public EllipseShape(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public void show(Canvas canvas) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.PINK);
        gc.fillOval(x, y, width, height);
        gc.strokeOval(x, y, width, height);
    }
}

