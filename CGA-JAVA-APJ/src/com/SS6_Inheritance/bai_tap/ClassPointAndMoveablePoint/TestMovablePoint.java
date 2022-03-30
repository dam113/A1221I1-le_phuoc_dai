package com.SS6_Inheritance.bai_tap.ClassPointAndMoveablePoint;

public class TestMovablePoint {
    public static void main(String[] args) {
        MovablePoint movablePoint = new MovablePoint();
        System.out.println(movablePoint);

        movablePoint.setSpeed(1, 2);
        System.out.println(movablePoint);


        System.out.println(movablePoint.move());
    }
}
