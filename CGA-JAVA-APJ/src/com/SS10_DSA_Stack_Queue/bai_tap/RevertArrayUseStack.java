package com.SS10_DSA_Stack_Queue.bai_tap;

import java.util.Arrays;
import java.util.Stack;

public class RevertArrayUseStack {
    public static void main(String[] args) {
        int[] a = {1,2,9,4,5,3};
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < a.length; i++) {
            stack.push(a[i]);
        }

        for (int i = 0; i < a.length; i++) {
            a[i]=stack.pop();
        }

        System.out.println(Arrays.toString(a));
    }
}
