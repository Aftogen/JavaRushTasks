package com.javarush.task.task37.task3710.decorators;

import com.javarush.task.task37.task3710.shapes.Shape;

public class RedShapeDecorator extends ShapeDecorator {

    private Shape shape;

    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
        this.shape = decoratedShape;
    }

    private void setBorderColor(Shape shape) {
        String className = shape.getClass().getSimpleName();
        System.out.println("Setting border color for " + className + " to red.");
    }

    @Override
    public void draw() {
        setBorderColor(shape);
        super.draw();
    }
}
