package com.SS1_Introduction_to_java.bai_tap;

import java.util.Scanner;

public class ConvertUsdToVN {
    // Chuyển đổi tiền tệ
    public static void main(String[] args) {
        final int rate = 23000;
        System.out.println("Đổi USD sang VIỆT NAM ĐỒNG ");
        System.out.println("Nhập số USD cần đổi");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int vnd = num * rate;
        System.out.println(num + " USD = " + vnd + " VND");
    }
}
