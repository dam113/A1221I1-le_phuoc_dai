package com.SS2_LoopInJava.bai_tap;

import java.util.Scanner;

public class Display20PrimeNum {
    public static void main(String[] args) {
        //Hiển thị 20 số nguyên tố đầu tiên
        System.out.println("Nhập số lượng nguyên tố cần in ra");
        Scanner input = new Scanner(System.in);
        int numbers = input.nextInt();
        int count = 0;
        for (int i = 0; i < 1000; i++) {
            if (checkNum(i)) {
                System.out.println(i);
                count++;
            }
            if (count == numbers){
                break;
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
