package com.SS6_Inheritance.bai_tap.ClassPointAndMoveablePoint;

public class MovablePoint extends Point{
    private float xSpeed;
    private float ySpeed;

    public MovablePoint() {
    }

    public MovablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MovablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getySpeed() {
        return ySpeed;
    }

    public void setySpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void setSpeed(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float[] getSpeed() {
        float[] arr = {xSpeed,ySpeed};
        return arr;
    }

    @Override
    public String toString() {
        return "Which is a subclass of"
                + super.toString() + " ,speed=" +
                "(" + xSpeed +","+ ySpeed + ")"
                +'}';
    }

    public MovablePoint move(){
        float a = 0.0f;
        a += xSpeed;
        float b = 0.0f;
        b += ySpeed;
        setXY(a,b);
        return this;
    }
}
