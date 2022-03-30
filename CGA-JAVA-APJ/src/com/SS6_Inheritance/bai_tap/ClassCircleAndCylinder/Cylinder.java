package com.SS6_Inheritance.bai_tap.ClassCircleAndCylinder;

public class Cylinder extends Circle{
    private double h = 1.0;

    public Cylinder() {
    }

    public Cylinder(double h, double radius, String color) {
        super(radius,color);
        this.h = h;
    }
    public double getH() {
        return h;
    }
    public void setH(double h) {
        this.h = h;
    }
    public double getArea(){
        final double pi = 3.14;
        return Cylinder.super.getRadius()*getRadius()*h*pi;
    }
    public String toString() {
        return  getH()
                + " Area Circle = "
                + getArea()
                + ", which is a subclass of "
                + super.toString();
    }
}
