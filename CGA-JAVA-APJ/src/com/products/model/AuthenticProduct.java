package com.products.model;

public class AuthenticProduct extends Product{
    private int granteeByYear;

    public AuthenticProduct(int granteeByYear) {
        this.granteeByYear = granteeByYear;
    }

    public AuthenticProduct(int id, String name, Double price, String manufacturer, int granteeByYear) {
        super(id, name, price, manufacturer);
        this.granteeByYear = granteeByYear;
    }

    public int getGranteeByYear() {
        return granteeByYear;
    }

    public void setGranteeByYear(int granteeByYear) {
        this.granteeByYear = granteeByYear;
    }

    @Override
    public String toString() {
        return super.toString() + granteeByYear;
    }
}
