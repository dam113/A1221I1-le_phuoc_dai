package com.SS6_Inheritance.bai_tap.ClassTriangle;

public class TestTriangle {
    public static void main(String[] args) {
        Triangle triangle = new Triangle();
        System.out.println(triangle);

        triangle.setSide1(5);
        triangle.setSide2(6);
        triangle.setSide3(7);
        triangle.setFilled(false);
        System.out.println(triangle);
    }
}
