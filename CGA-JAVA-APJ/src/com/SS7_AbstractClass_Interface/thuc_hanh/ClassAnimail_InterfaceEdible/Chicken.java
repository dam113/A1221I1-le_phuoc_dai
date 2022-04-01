package com.SS7_AbstractClass_Interface.thuc_hanh.ClassAnimail_InterfaceEdible;

public class Chicken extends Animal implements Edible{

    @Override
    public String makeSound() {
        return "Chicken : cluck-cluck!";
    }

    @Override
    public String howToEat() {
        return "Could be fried";
    }
}
