package com.SS3_Array_Method.bai_tap;

import java.util.Scanner;

public class CountCharOfString {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập ký tự bất kỳ : ");
        String x = input.nextLine();
        String string = "Hello World!";
        int count = 0;
        for (int i = 0; i < string.length(); i++) {
            String ch = String.valueOf(string.charAt(i));
            if ( ch.equalsIgnoreCase(x)){
                count++;
            }
        }
        System.out.println("Ký tự " + x + " xuất hiện " + count + " Trong chuỗi" + string);
    }
}
