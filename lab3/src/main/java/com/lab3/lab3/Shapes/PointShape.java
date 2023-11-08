package com.lab3.lab3.Shapes;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class PointShape extends Shape {
    double x;
    double y;

    public PointShape(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void show(Canvas canvas) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.BLACK);
        double dotSize = 5;
        gc.fillOval(this.x - dotSize / 2, this.y - dotSize / 2, dotSize, dotSize);
    }
}