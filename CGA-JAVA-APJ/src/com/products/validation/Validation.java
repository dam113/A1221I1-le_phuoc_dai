package com.products.validation;

public class Validation {
    public static boolean validPrice(String price) {
        try {
            return Double.valueOf(price) > 10000;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean validSoLuong(String soLuong) {
        try {
            return Double.valueOf(soLuong) > 0;
        } catch (Exception e) {
            return false;
        }
    }
}
