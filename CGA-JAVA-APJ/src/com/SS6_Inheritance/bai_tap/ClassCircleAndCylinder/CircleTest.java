package com.SS6_Inheritance.bai_tap.ClassCircleAndCylinder;

import com.SS6_Inheritance.thuc_hanh.GeometricObjectSystem.Shape;

public class CircleTest {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle);

        circle = new Circle(3, "red");
        System.out.println(circle);
    }
}
