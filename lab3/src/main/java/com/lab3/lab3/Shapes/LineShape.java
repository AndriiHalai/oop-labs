package com.lab3.lab3.Shapes;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class LineShape extends Shape{
    double x1;
    double y1;
    double x2;
    double y2;

    public LineShape(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
    public void show(Canvas canvas) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.BLACK);
        gc.setLineDashes(0);
        gc.strokeLine(x1, y1, x2, y2);
    }
}
