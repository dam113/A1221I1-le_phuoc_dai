package com.SS6_Inheritance.bai_tap.ClassPoint2DAndPoint3D;

public class TestPoint3D {
    public static void main(String[] args) {
        Point3D point3D = new Point3D();
        System.out.println(point3D.toString());

        point3D.setXYZ(3,5, 7);
        System.out.println(point3D.toString());
    }
}
