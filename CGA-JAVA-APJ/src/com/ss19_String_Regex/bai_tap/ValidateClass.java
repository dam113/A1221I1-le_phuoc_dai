package com.ss19_String_Regex.bai_tap;

import java.util.Scanner;

public class ValidateClass {
    private static final String regex_Name = "^([CAP])[0-9]{4}([GHIKLM])$";
    public static void main(String[] args) {
        System.out.println("Nhập tên lớp: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        if (name.matches(regex_Name)){
            System.out.println("tên lớp hợp lệ");
        }else {
            System.out.println("tên lớp không hợp lệ");
        }
    }
}
