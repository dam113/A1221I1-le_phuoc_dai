package com.products.validation;

public class Validation {
    private static final String MANUFACTURER_REGEX = "[ABC]\\w*";

    public static boolean validPrice(String price){
        try {
            return Double.valueOf(price) > 50;
        }
        catch(Exception e){
            return false;
        }
    }

    public static boolean validManufacturer(String manufacturer){
        return manufacturer.matches(MANUFACTURER_REGEX);
    }
}
