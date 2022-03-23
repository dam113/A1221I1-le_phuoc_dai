package com.SS3_Array_Method.bai_tap;

public class GroupArray {
    //Gộp mảng
    public static void main(String[] args) {
        int[] arr1 = {1,2,3};
        System.out.print("Mảng 1: ");
        for (int j = 0; j < arr1.length; j++) {
            System.out.print(arr1[j] + "\t");
        }
        int[] arr2 = {4,5,6};
        System.out.print("\n Mảng 2: ");
        for (int j = 0; j < arr2.length; j++) {
            System.out.print(arr2[j] + "\t");
        }
        int size = arr1.length + arr2.length;
        int[] arr3 = new int[size];
        for (int i = 0; i < arr1.length; i++){
            arr3[i] = arr1[i];
        }
        for (int j = arr1.length; j < arr3.length; j++){
                arr3[j] = arr2[j - arr1.length];
        }
        System.out.print("\n Mảng sau khi gộp: ");
        for (int j = 0; j < arr3.length; j++) {
            System.out.print(arr3[j] + "\t");
        }
    }
}
