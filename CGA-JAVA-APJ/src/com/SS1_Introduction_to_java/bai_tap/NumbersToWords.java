package com.SS1_Introduction_to_java.bai_tap;

import java.util.Scanner;

public class NumbersToWords {
    public static void main(String[] args) {
        System.out.println("Enter Numbers: ");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        if (num < 10){
            checkNum(num);
        }else if (num < 20){
            if (num == 10){
                System.out.println("mười");
            }else {
                int num_new = num/10;
                System.out.println("mười " + checkNum(num_new));
            }
        }else if (num < 100){
            String string = "teen";
        }
    }
    public static String checkNum(int num){
        String string = "";
        switch (num){
            case 0:
                string = "không";
                break;
            case 1:
                string = "một";
                break;
            case 2:
                string = "hai";
                break;
            case 3:
                string = "ba";
                break;
            case 4:
                string = "bốn";
                break;
            case 5:
                string = "năm";
                break;
            case 6:
                string = "sáu";
                break;
            case 7:
                string = "bảy";
                break;
            case 8:
                string = "tám";
                break;
            case 9:
                string = "chín";
                break;
        }
        return string;
    }
}
