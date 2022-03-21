package com.SS1_Introduction_to_java.bai_tap;

import java.util.Scanner;

public class NumbersToWords {
    public static void main(String[] args) {
        System.out.println("Enter Numbers: ");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        if (num < 10) {
            System.out.println(checkNum1(num));
        } else if (num < 20) {
            if (num < 14) {
                System.out.println(checkNum1(num));
            }else {
                int num_new = num%10;
                System.out.println(checkNum1(num_new) + "teen");
            }
        } else if (num < 100) {
            int numDozens = num/10;
            int numUnit = num%10;
            System.out.println(checkNum2(numDozens) + " " + checkNum1(numUnit));
        }else if(num < 1000){
            int numHundreds = num/100;
            int numD = (num%100)/10;
            int numU = (num%100)%10;
            System.out.println(checkNum1(numHundreds) + " Hunderds " + checkNum2(numD) + " " + checkNum1(numU));
        }
    }

    public static String checkNum1(int num) {
        String string = "";
        switch (num) {
            case 1:
                string = "one";
                break;
            case 2:
                string = "two";
                break;
            case 3:
                string = "three";
                break;
            case 4:
                string = "four";
                break;
            case 5:
                string = "five";
                break;
            case 6:
                string = "six";
                break;
            case 7:
                string = "seven";
                break;
            case 8:
                string = "eight";
                break;
            case 9:
                string = "nine";
                break;
            case 10:
                string = "ten";
                break;
            case 11:
                string = "eleven";
                break;
            case 12:
                string = "twelve";
                break;
            case 13:
                string = "thirteen";
                break;
        }
        return string;
    }
    public static String checkNum2(int num) {
        String string = "";
        switch (num){
            case 2:
                string = "twenty";
                break;
            case 3:
                string = "thirty";
                break;
            case 4:
                string = "forty";
                break;
            case 5:
                string = "fifty";
                break;
            case 6:
                string = "sixty";
                break;
            case 7:
                string = "seventy";
                break;
            case 8:
                string = "eighty";
                break;
            case 9:
                string = "ninety";
                break;
        }
        return string;
    }

}
