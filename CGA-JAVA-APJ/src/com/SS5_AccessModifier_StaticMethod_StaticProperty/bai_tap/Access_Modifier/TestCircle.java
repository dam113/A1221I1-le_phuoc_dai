package com.SS5_AccessModifier_StaticMethod_StaticProperty.bai_tap.Access_Modifier;

public class TestCircle {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle.getRadius());
        System.out.println( circle.getArea());
        // Nếu đổi thành Private thì chương trình TestCircle báo lỗi
        //java: getRadius() has private access in com.SS5_AccessModifier_StaticMethod_StaticProperty.bai_tap.Access_Modifier.Circle
        //trong phạm vị package thì sử dụng public, protected, default
    }
}
