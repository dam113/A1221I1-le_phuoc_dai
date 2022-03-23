package com.SS3_Array_Method.bai_tap;

import java.util.Scanner;

public class FindElementMaxArrayTwoWay {
    public static void main(String[] args) {
        int[][] array = importArrayTypeInt();
        System.out.print("mảng 2 chiều : ");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++){
                System.out.print(array[i][j] + "\t");
            }
            System.out.print("\n");
        }
        int max = array[0][0];
        int index_i = 0;
        int index_j = 0;
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[i].length; j++){
                if (max < array[i][j]){
                    max = array[i][j];
                    index_i = i;
                    index_j = j;
                }
            }
        }
        System.out.print("Giá trị lớn nhất của mảng 2 chiều là: " + max + " thuộc array[ " + index_i + " ][ " + index_j +" ]");
    }
    public static int[][] importArrayTypeInt(){
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập số hàng của mảng ");
        int index_i = Integer.parseInt(input.nextLine());
        System.out.print("Nhập số cột của mảng ");
        int index_j = Integer.parseInt(input.nextLine());
        int[][] arr = new int[index_i][index_j];
        for (int i = 0; i < index_i; i++){
            for (int j = 0; j < index_j; j++){
                System.out.println("Nhập giá trị arr[ " + i + " ][ " + j + " ]");
                arr[i][j] = Integer.parseInt(input.nextLine());
            }
        }
        return arr;
    }
}
