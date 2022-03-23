package com.SS3_Array_Method.bai_tap;

import java.util.Scanner;

public class CalSumInDeterminedCol {
    //Tính tổng các số ở một cột xác định
    public static void main(String[] args) {
        int[][] array = {
                {1,2,3,4},
                {5,6,7,8},
                {1,5,6,7},
                {9,2,1,5}
        };
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập số cột muốn tính tổng");
        int num = Integer.parseInt(input.nextLine());
        int total = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (j == num){
                    total += array[i][j];
                }
            }
        }
        System.out.println("Tổng của cột " + num + " = " + total);
    }
}
