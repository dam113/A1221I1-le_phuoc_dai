package com.SS6_Inheritance.bai_tap.ClassTriangle;

public class Triangle extends Shape{
    private double side1 = 1.0;
    private double side2 = 1.0;
    private double side3 = 1.0;

    public Triangle() {
    }

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public Triangle(String color, boolean filled, double side1, double side2, double side3) {
        super(color, filled);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    public double getPerimeter(){
        double p = side1 + side2 + side3;
        return p;
    }

    public double getArea(){
        double p = getPerimeter();
        double s = Math.sqrt(p*(p-side1)*(p-side2)*(p-side3));
        return s;
    }

    @Override
    public String toString() {
        return  super.toString()+
                " Triangle{" +
                " side1=" + side1 +
                " ,side2=" + side2 +
                " ,side3=" + side3 +
                "} " +
                " Area = " + getArea() +
                " Perimeter = " + getPerimeter();
    }
}
