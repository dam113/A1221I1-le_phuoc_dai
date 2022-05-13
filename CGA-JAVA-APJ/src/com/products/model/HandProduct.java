package com.products.model;

public class HandProduct extends Product{
    private String country;
    private String status;

    public HandProduct(String country, String status) {
        this.country = country;
        this.status = status;
    }

    public HandProduct(int id, String name, Double price, String manufacturer, String country, String status) {
        super(id, name, price, manufacturer);
        this.country = country;
        this.status = status;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return super.toString() + country + "," + status;
    }
}
