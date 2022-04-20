package com.SS12_JavaCollectionFramework.bai_tap.ArrayList_LinkedList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    static ArrayList<Product> arrayList = new ArrayList<>();

    private static void create(Product product) {
        arrayList.add(product);
    }

    private static void displayProduct() {
        for (Product product : arrayList) {
            System.out.println("Name: " + product.getName() + " -  Price: " + product.getPrice());
        }
    }

    private static void update(Product product, String nameEdit) {
        product.setName(nameEdit);
    }
    private static void update(Product product, double priceEdit) {
        product.setPrice(priceEdit);
    }

    private static void delete(Product product) {
        arrayList.remove(product);
    }

    private static boolean search(ArrayList<Product> arrayList, String name) {
        boolean result = false;
        for (Product product : arrayList) {
            if (product.getName().equals(name)) {
                result = true;
            }
        }
        return result;
    }

    private static void sort() {

        arrayList.sort((o1,o2)->(int)(o1.getPrice()-o2.getPrice()));
    }

    public static void main(String[] args) {
        System.out.println("Create Product: ");
        Product product1 = new Product(1, "Nokia", 100);
        Product product2 = new Product(2, "Samsung", 300);
        Product product3 = new Product(3, "Iphone", 400);
        Product product4 = new Product(4, "Bphone", 180);
        Product product5 = new Product(5, "Oppo", 80);
        create(product1);
        create(product2);
        create(product3);
        create(product4);
        create(product5);
        displayProduct();
        System.out.println("Update Product: ");
        update(product1, "Nokia Edit");
        displayProduct();
        System.out.println("Delete Product: ");
        delete(product3);
        displayProduct();
        System.out.println("Search..." + search(arrayList, "Oppo"));
        System.out.println("Sort...");
        sort();
        System.out.println("Read...");
        displayProduct();
    }
}
