package com.SS2_LoopInJava.bai_tap;

public class Drawing {
    public static void main(String[] args) {
        //Hiển thị các loại hình
        //Vẽ hình chữ nhật
        System.out.println("Hình chữ nhật");
        for (int i = 0; i < 3; i++) {
            String string = "";
            for (int j = 0; j < 7; j++) {
                string += "*";
            }
            System.out.println(string);
        }

        //Vẽ hình tam giác
//        *
//        **
//        ***
//        ****
//        *****
        System.out.println("Hình Tam giác");
        for (int i = 0; i < 5; i++) {
            String string = "";
            for (int j = 0; j < i + 1; j++) {
                string += "*";
            }
            System.out.println(string);
        }

        //Vẽ hình tam giác ngược
//        *****
//        ****
//        ***
//        **
//        *
        System.out.println("Hình tam giác ngược");
        for (int i = 5; i >= 1; i--) {
            String string = "";
            for (int j = 1; j <= i; j++) {
                string += "*";
            }
            System.out.println(string);
        }

        //vẽ tam giác cân
//            *
//           ***
//          *****
//         *******
//        *********
        System.out.println("vẽ tam giác cân");
        for (int i = 0; i < 5; i++) {
            String string1 = "";
            String string2 = "";
            for (int k = 4 - i; k > 0; k--) {
                string1 += " ";
            }
            for (int j = 1; j <= (i * 2) + 1; j++) {
                string2 += "*";
            }
            System.out.println(string1 + string2);
        }
    }
}
