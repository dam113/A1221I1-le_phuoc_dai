package com.SS3_Array_Method.bai_tap;

public class CalTotal2DiagonalInMatrix {
    //Tính tổng 2 đường chéo của ma trận
    public static void main(String[] args) {
        int[][] array = {
                {1,2,3,4},
                {5,6,7,8},
                {1,5,6,7},
                {9,2,1,5}
        };
        int total = 0;
        //tính tổng đường chéo thứ nhất
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i == j){
                    total += array[i][j];
                }
            }
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = array[i].length - 1; j >= 0; j--) {
                if (j == array[i].length - 1 - i){
                    total += array[i][j];
                }
            }
        }
        System.out.println("Tổng của 2 đường chéo của ma trận là = " + total);
    }
}
