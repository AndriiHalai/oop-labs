package com.lab2.lab2.Editors;

import javafx.scene.canvas.Canvas;

public abstract class ShapeEditor {
    protected abstract void onMousePressed(Canvas canvas);
    protected abstract void onMouseDragged(Canvas canvas);
    protected abstract void onMouseReleased(Canvas canvas);
}
