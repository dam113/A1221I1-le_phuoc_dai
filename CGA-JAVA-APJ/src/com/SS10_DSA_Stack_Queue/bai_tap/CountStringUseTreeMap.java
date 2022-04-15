//Đếm số lần xuất hiện của mỗi từ trong một chuỗi sử dụng Map
package com.SS10_DSA_Stack_Queue.bai_tap;

import java.util.Scanner;
import java.util.TreeMap;

public class CountStringUseTreeMap {
    public static void main(String[] args) {
        System.out.println("Input a string:");
        String st = new Scanner(System.in).nextLine();
        String[] a = st.toLowerCase().split("");
        TreeMap<Character,Integer> t= new TreeMap<>();
        int tmp=1;
        for (int i = 0; i < a.length; i++) {
            char c= a[i].charAt(0);
            if(!t.containsKey(c)){
                t.put(c,tmp);
            }
            else{
                t.replace(c,tmp+1);
            }
        }

        System.out.println(t);
    }
}
