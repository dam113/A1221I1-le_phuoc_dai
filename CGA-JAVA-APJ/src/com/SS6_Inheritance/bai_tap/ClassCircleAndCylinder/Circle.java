package com.SS6_Inheritance.bai_tap.ClassCircleAndCylinder;

public class Circle {
    private double radius = 1.0;
    private String color = "black";

    public Circle() {
    }

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public double getArea(){
        final double pi = 3.14;
        return radius*radius*pi;
    }

    @Override
    public String toString() {
        return "A Circle with radius = "
                + getRadius()
                + " color of "
                + getColor()
                + " Area Circle = "
                + getArea();
    }
}
