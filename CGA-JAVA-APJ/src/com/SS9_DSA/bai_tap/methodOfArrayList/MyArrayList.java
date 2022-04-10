package com.SS9_DSA.bai_tap.methodOfArrayList;

import java.util.Arrays;

public class MyArrayList<E>{
    private static final int DEFAULT_CAPACITY = 10;
    private E[] elements;
    private int size;

    MyArrayList() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    MyArrayList(int initCapacity) {
        elements = (E[]) new Object[initCapacity];
    }

    public void add(int index, E element) {
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("Giá trị index truyền vào phải > 0 và < size");
        }
        ensureCapacity();
        for (int i = size; i > index; i--){
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        size++;
    }

    public boolean add(E e) {
        add(size, e);
        return true;
    }

    public E remove(int index) {
        E[] tempArray = (E[]) new Object[size - 1];
        E result= elements[index];
        for (int i = 0, j = 0; i < size; i++) {
            if (i != index){
                tempArray[j++] = elements[i];
            }
        }
        elements = tempArray;
        size--;
        return result;

    }

    public int size() {
        return size;
    }

    public E get(int index) {
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException("Giá trị index truyền vào phải > 0 và < size");
        }
        return elements[index];
    }

    public boolean cointains(E e){
        for (int i = 0; i < size; i++) {
            if(elements[i].equals(e)){
                return true;
            }
        }
        return false;
    }

    public int indexOf(E e){
        for (int i = 0; i < size; i++) {
            if(elements[i].equals(e)){
                return i;
            }
        }
        return -1;
    }

    public void clear(){
        size = 0;
        elements = (E[])new Object[DEFAULT_CAPACITY];
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    private void ensureCapacity() {
        if (size >= elements.length){
            final int newLength = elements.length * 3 / 2;
            elements = Arrays.copyOf(elements, newLength);
        }
    }
}
