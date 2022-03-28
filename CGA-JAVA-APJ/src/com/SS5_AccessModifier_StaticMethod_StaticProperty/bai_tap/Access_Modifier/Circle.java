package com.SS5_AccessModifier_StaticMethod_StaticProperty.bai_tap.Access_Modifier;

public class Circle {
    private double radius = 1.0;
    private String color = "red";

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public double getArea(){
        final double Pi = 3.14;
        return 2*radius*Pi;
    }
//    thay đổi Access Modifier thành private
//    private double getRadius() {
//        return radius;
//    }
//
//    private double getArea(){
//        final double Pi = 3.14;
//        return 2*radius*Pi;
//    }
}
