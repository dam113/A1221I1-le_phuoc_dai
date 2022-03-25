package com.SS4_ClassAndObject.bai_tap;

public class Fan {
    private final byte slow = 1;
    private final byte medium = 2;
    private final byte fast = 3;

    private byte speed = slow;
    private boolean turnOn = false;
    private double radius = 5;
    private String color = "blue";

    public byte getSlow() {
        return slow;
    }

    public byte getMedium() {
        return medium;
    }

    public byte getFast() {
        return fast;
    }

    public byte getSpeed() {
        return speed;
    }

    public void setSpeed(byte speed) {
        this.speed = speed;
    }

    public boolean isTurnOn() {
        return turnOn;
    }

    public void setTurnOn(boolean turnOn) {
        this.turnOn = turnOn;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String toString(){
        String string = "";
        if (isTurnOn()){
            string = "Speed: " + getSpeed() + " color: " + getColor() + " radius: " + getRadius() + " fan is on";
        }else {
            string = "color: " + getColor() + " radius: " + getRadius() + " fan is off";
        }
        return string;
    }

    public static void main(String[] args) {
        Fan fan1 = new Fan();
        fan1.setSpeed(fan1.fast);
        fan1.setRadius(10);
        fan1.setColor("yellow");
        fan1.setTurnOn(true);
        Fan fan2 = new Fan();
        fan2.setSpeed(fan2.medium);
        fan2.setRadius(5);

        System.out.println("Quạt 1: " + fan1.toString());
        System.out.println("Quạt 2: " + fan2.toString());
    }
}
