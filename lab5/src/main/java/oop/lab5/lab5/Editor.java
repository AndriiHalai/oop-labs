package oop.lab5.lab5;

import javafx.scene.canvas.Canvas;
import oop.lab5.lab5.Shapes.Shape;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Editor {

    public static List<Observer> observers = new ArrayList<>();

    public static final ArrayList<Shape> SHAPE_ARRAY_LIST = new ArrayList<>();

    private static TableController tableController;
    public static void addShape(Shape shape) {
        SHAPE_ARRAY_LIST.add(shape);
//        tableController.add(shape);
        try {
            notifyObservers(shape);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Editor() {}

    private static class EditorHolder {
        static final Editor INSTANCE = new Editor();
    }

    public static Editor getInstance() {
        return EditorHolder.INSTANCE;
    }

    public static void redrawCanvas(Canvas canvas) {
        for (Shape shape : SHAPE_ARRAY_LIST) {
            shape.show(canvas);
        }
    }

    public static void clearCanvas(Canvas canvas) {
        canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

    public static void draw(Shape shape, Canvas canvas) {
        shape.onMousePressed(canvas);
        shape.onMouseDragged(canvas);
        shape.onMouseReleased(canvas);
    }

    public static void addObserver(Observer observer) {
        observers.add(observer);
    }

    public static void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public static void notifyObservers(Shape shape) throws IOException {
        for (Observer observer : observers) {
            observer.update(shape);
        }
    }
}
