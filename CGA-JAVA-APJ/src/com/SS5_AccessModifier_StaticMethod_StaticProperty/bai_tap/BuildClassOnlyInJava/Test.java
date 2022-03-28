package com.SS5_AccessModifier_StaticMethod_StaticProperty.bai_tap.BuildClassOnlyInJava;

public class Test extends Student{
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("nam");
        student.setClasses("C03");
        System.out.println(student.getName() + " " + student.getClasses());
    }
}
