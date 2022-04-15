package com.SS10_DSA.thuc_hanh.my_List;

import java.util.Arrays;

public class MyList<E> {
    //size xác định số phần tử trong danh sách, mặc định gán là 0.
    //DEFAULT_CAPACITY lưu số phần tử đối đa trong danh sách mặc định là 10.
    //Mảng đối tượng elements chứa các phần tử trong danh sách
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    private void ensureCapa() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    public void add(E e) {
        if (size == elements.length) {
            ensureCapa();
        }
        elements[size++] = e;
    }

    public E get(int i) {
        if (i>= size || i <0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i );
        }
        return (E) elements[i];
    }
}
