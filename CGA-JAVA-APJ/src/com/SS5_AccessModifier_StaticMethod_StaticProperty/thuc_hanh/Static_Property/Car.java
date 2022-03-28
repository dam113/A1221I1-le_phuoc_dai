package com.SS5_AccessModifier_StaticMethod_StaticProperty.thuc_hanh.Static_Property;

public class Car {
    private String name;

    private String engine;



    public static int numberOfCars;



    public Car(String name, String engine) {

        this.name = name;

        this.engine = engine;

        numberOfCars++;
    }
}
