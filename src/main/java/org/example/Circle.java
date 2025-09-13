package org.example;

public class Circle {

    private final float radius, x, y;

    public Circle(float radius, float x, float y) {
        this.radius = radius;
        this.x = x;
        this.y = y;
    }

    public float getRadius() {
        return radius;
    }
    public void manipulate(Circle circle){
        circle = new Circle(5.0f, 0, 0);
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public Circle(Circle original) {
        radius = original.radius;
        x = original.x;
        y = original.y;
    }
    public Circle(float radius, Square square, float y){
        this.radius = radius;
        this.x = square.getBreadth();
        this.y = y;
    }
    public static class CircleBuilder{
        public CircleBuilder ofOrigin(float x, float y){
            return this;
        }
    }
}
