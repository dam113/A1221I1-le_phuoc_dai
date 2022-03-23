package com.SS3_Array_Method.bai_tap;

import java.util.Scanner;

public class DelElementInArray {
    //Xóa phẩn tử trong mảng
    public static void main(String[] args) {
        //KHởi tạo vào nhập phần tử vào cho mảng
        int size;
        int[] array;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Enter a size: ");
            size = Integer.parseInt(scanner.nextLine());
            if (size > 20)
                System.out.println("Size should not exceed 20 ");
        } while (size > 20);
        array = new int[size];
        int i = 0;
        while (i < array.length) {
            System.out.print("Enter element " + (i + 1) + " : ");
            array[i] = Integer.parseInt(scanner.nextLine());
            i++;
        }
        System.out.print("Property list: ");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + "\t");
        }
        //Khởi tạo vào nhập x là số phần tử cần xóa
        //Duyệt mảng và tìm x có phải là phần tử của mảng hay không và gán index_del = index cảu mảng;
        // khởi tạo biến check để kiểm tra xem x có nằm trong mảng hay ko.
        // Nếu có thực hiện xóa phần tử đó trong mảng, nếu không thì in ra x không có trong mảng
        int index_del = 0;
        boolean check = false;
        int x;
        System.out.print("\n Enter a X: ");
        x = Integer.parseInt(scanner.nextLine());
        for (int j = 0; j < array.length; j++) {
            if (array[j] == x){
                index_del = j;
                check = true;
                break;
            }
        }
        if (check){
            //Duyệt mảng từ vị trí cần xoá (index_del) đến cuối mảng (array.length-1)
            for (int j = index_del; j < array.length-1; j++){
                array[j] = array[j +1];
            }
            //in ra mảng mới
            System.out.print("Property list: ");
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[j] + "\t");
            }
        }else {
            System.out.print("X không có trong mảng ");
        }
    }
}
