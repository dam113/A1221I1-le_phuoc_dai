//Đếm số lần xuất hiện của mỗi từ trong một chuỗi sử dụng Map
package com.SS11_DSA_Stack_Queue.bai_tap;

import java.util.Scanner;
import java.util.TreeMap;

public class CountStringUseTreeMap {
    public static void main(String[] args) {
        System.out.println("Input a string:");
        String st = new Scanner(System.in).nextLine();
        String[] a = st.toLowerCase().split("");
        TreeMap<Character,Integer> tree = new TreeMap<>();
        int tmp = 1;
        for (int i = 0; i < a.length; i++) {
            char c = a[i].charAt(0);
            if(!tree.containsKey(c)){
                tree.put(c,tmp);
            }
            else{
                tree.replace(c,tree.get(c)+1);
            }
        }

        System.out.println(tree);
    }
}
