package com.SS4_ClassAndObject.bai_tap;

import java.util.Scanner;

public class QuadraticEquation {
    private double a;
    private double b;
    private double c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double getDiscriminant(){
        double delta = getB()*getB() - 4*getA()*getC();
        return delta;
    }
    public double getRoot1(){
        double r1 = (-getB() + Math.sqrt(getB()*getB() - 4*getA()*getC()))/2*getA();
        return r1;
    }
    public double getRoot2(){
        double r2 = (-getB() - Math.sqrt(getB()*getB() - 4*getA()*getC()))/2*getA();
        return r2;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập a: ");
        double a = Double.parseDouble(input.nextLine());
        System.out.println("Nhập b: ");
        double b = Double.parseDouble(input.nextLine());
        System.out.println("Nhập c: ");
        double c = Double.parseDouble(input.nextLine());
        QuadraticEquation quadraticEquation = new QuadraticEquation(a,b,c);
        double delta = quadraticEquation.getDiscriminant();
        if (delta > 0){
            System.out.println("Phương trình có 2 nghiệm");
            System.out.println("Nghiệm thứ nhất : " + quadraticEquation.getRoot1());
            System.out.println("Nghiệm thứ hai : " + quadraticEquation.getRoot2());
        }else if(delta == 0){
            System.out.println("Phương trình có 1 nghiệm kép");
            System.out.println("Nghiệm kép : " + quadraticEquation.getRoot1());
        }else {
            System.out.println("The equation has no roots");
        }
    }
}
