package oop.lab5.lab5.Shapes;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import oop.lab5.lab5.Editor;

public class EllipseShape extends Shape {
    private final String name = "Ellipse";

    private EllipseShape instance;

    private double x, y, x1, y1, x2, y2, width, height;

    @Override
    public void show(Canvas canvas) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.PINK);
        gc.fillOval(this.x1, this.y1, this.width, this.height);
        gc.strokeOval(this.x1, this.y1, this.width, this.height);
    }

    @Override
    public void onMousePressed(Canvas canvas) {
        canvas.setOnMousePressed(mouseEvent -> {
            this.x = mouseEvent.getX();
            this.y = mouseEvent.getY();
        });
    }

    @Override
    public void onMouseDragged(Canvas canvas) {
        canvas.setOnMouseDragged(mouseEvent -> {
            Editor.clearCanvas(canvas);
            Editor.redrawCanvas(canvas);
            GraphicsContext gc = canvas.getGraphicsContext2D();
            this.x2 = mouseEvent.getX();
            this.y2 = mouseEvent.getY();
            if (this.y2 >= this.y && this.x2 >= this.x) { // BOTTOM RIGHT ANGLE
                this.x1 = this.x - Math.abs(this.x2 - this.x);
                this.y1 = this.y - Math.abs(this.y2 - this.y);
                this.width = Math.abs(this.x2 - this.x1);
                this.height = Math.abs(this.y2 - this.y1);
            } else if (this.y2 >= this.y && this.x2 <= this.x) { // BOTTOM LEFT ANGLE
                this.x1 = this.x - Math.abs(this.x2 - this.x);
                this.y1 = this.y - Math.abs(this.y2 - this.y);
                this.width = this.x + Math.abs(this.x2 - this.x) - this.x1;
                this.height = this.y2 - this.y1;
            } else if (this.y2 <= this.y && this.x2 <= this.x) { // TOP LEFT ANGLE
                this.x1 = this.x2;
                this.y1 = this.y2;
                this.x2 = this.x + Math.abs(this.x2 - this.x);
                this.y2 = this.y + Math.abs(this.y2 - this.y);
                this.width = Math.abs(this.x2 - this.x1);
                this.height = Math.abs(this.y2 - this.y1);
            } else if (y2 <= y && x2 >= x) { // TOP RIGHT ANGLE
                this.x1 = this.x - Math.abs(this.x2 - this.x);
                this.y1 = this.y - Math.abs(this.y2 - this.y);
                this.width = Math.abs(this.x2 - this.x1);
                this.height = 2 * Math.abs(this.y - this.y1);
            }
            gc.setLineDashes(5);
            gc.strokeOval(this.x1, this.y1, this.width, this.height);
            gc.setLineDashes(0);
        });
    }

    @Override
    public void onMouseReleased(Canvas canvas) {
        canvas.setOnMouseReleased(mouseEvent -> {
            Editor.clearCanvas(canvas);
            Editor.redrawCanvas(canvas);
            EllipseShape ellipse = new EllipseShape();
            ellipse.setCoords(this.x1, this.y1, this.width, this.height);
            ellipse.show(canvas);
            Editor.addShape(ellipse);
            this.instance = ellipse;
        });
    }

    public void setCoords(double x1, double y1, double width, double height) {
        this.x1 = x1;
        this.y1 = y1;
        this.width = width;
        this.height = height;
    }

    public EllipseShape getInstance() {
        return this.instance;
    }

    public String getName() {
        return this.name;
    }

    public double getX1() {
        return this.x1;
    }

    public double getY1() {
        return this.y1;
    }

    public double getX2() {
        return this.x1 + this.width;
    }

    public double getY2() {
        return this.y1 + this.height;
    }
}

