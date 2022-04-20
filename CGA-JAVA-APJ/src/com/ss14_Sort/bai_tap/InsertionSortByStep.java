package com.ss14_Sort.bai_tap;

import java.util.Scanner;

public class InsertionSortByStep {
    public static void insertionSort(int[] list) {
        for (int i = 1; i < list.length; i++) {
            int key = list[i];
            int j = i - 1;
            System.out.println("gán " + key + " cho list[" + i + "]");
            while (j >= 0 && list[j] > key) {
                System.out.println("gán " + list[j] + " cho phần tử tại index =  " + (j + 1));
                list[j + 1] = list[j];
                j--;
            }
            System.out.print("List after the  " + i + " sort: ");
            for (int k = 0; k < list.length; k++) {
                System.out.print(list[k] + "\t");
            }

            System.out.println("\n gán " + key + " cho phần tử tại index =  " + (j + 1));
            list[j + 1] = key;

            System.out.print("List after the  " + i + " sort: ");
            for (int k = 0; k < list.length; k++) {
                System.out.print(list[k] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter list size:");
        int size = scanner.nextInt();
        int[] list = new int[size];
        System.out.println("Enter " + list.length + " values:");
        for (int i = 0; i < list.length; i++) {
            list[i] = scanner.nextInt();
        }
        System.out.print("Your input list: ");
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + "\t");
        }
        System.out.println("\nBegin sort processing...");
        insertionSort(list);
    }
}
