package com.SS3_Array_Method.bai_tap;

import java.util.Scanner;

public class MoreElementArray {
    //Thêm phần tử cho mảng
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] arr = {10,4,6,7,8,9,1,0,0,0};
        System.out.print("Mảng: ");
        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j] + "\t");
        }
        System.out.print("\n Nhập số cần thêm vào mảng: ");
        int x = Integer.parseInt(input.nextLine());
        System.out.println("Nhập số vị trí cần thêm vào mảng: ");
        int index = Integer.parseInt(input.nextLine());
        if (index <= 1 || index >= arr.length - 1){
            System.out.println("Không thể thêm phần tử X vào mảng");
        }else {
            for (int j = arr.length - 1; j > index; j--){
                arr[j] = arr[j - 1];
            }
            arr[index] = x;
        }
        System.out.print("Mảng sau khi thêm phần tử x: ");
        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j] + "\t");
        }
    }
}
