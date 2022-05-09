package com.ss19_String_Regex.bai_tap;

import java.util.Scanner;

public class ValidateNumber {
    private static final String regex_Name = "^\\([0-9]{2}\\)\\-\\([0][0-9]{9}\\)$";
    public static void main(String[] args) {
        System.out.println("Nhập số điện thoại: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        if (name.matches(regex_Name)){
            System.out.println("số điện thoại hợp lệ");
        }else {
            System.out.println("số điện thoại không hợp lệ");
        }
    }
}
