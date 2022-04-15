package com.SS10_DSA.bai_tap.methodOfArrayList;

public class TestMyArrayList {
    public static void main(String[] args) {
        MyArrayList<Integer> arrayList = new MyArrayList<>();
        arrayList.add(2);
        arrayList.add(8);
        arrayList.add(6);
        arrayList.add(1);
        arrayList.add(1, 5);
        arrayList.remove(1);

        System.out.println(arrayList.cointains(2));
        System.out.println(arrayList.indexOf(1));

        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }

        arrayList.clear();
    }
}
