package oop.lab5.lab5;

import oop.lab5.lab5.Shapes.Shape;

public class TableObserver implements Observer {
    @Override
    public void update(Shape shape) {
        Table table = Table.getInstance();
        table.addToTable(shape);
    }
}
