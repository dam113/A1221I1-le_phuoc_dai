package com.SS2_LoopInJava.bai_tap;

import java.util.Scanner;

public class ShowPrimeSmaller100 {
    //Hiển thị các số nguyên tố nhỏ hơn 100
    public static void main(String[] args) {
        for (int i = 2; i < 100; i++) {
            if (checkNum(i)) {
                System.out.println(i);
            }
        }
    }

    public static boolean checkNum(int number) {
        if (number < 2) {
            return true;
        } else {
            int i = 2;
            boolean check = true;
            while (i <= Math.sqrt(number)) {
                if (number % i == 0) {
                    check = false;
                    break;
                }
                i++;
            }
            if (check)
                return true;
            else
                return false;
        }
    }
}
