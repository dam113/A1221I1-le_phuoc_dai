package com.ss15_Exception_Debug.bai_tap.useIllegalTriangleException;

public class UseIllegalTriangleException {
    public static void main(String[] args) {
        try {
            Triangle triangle = new Triangle(-1, 2, 3);
        } catch (IllegalTriangleException e) {
            System.out.println(e.getMessage());
        }
    }
}
