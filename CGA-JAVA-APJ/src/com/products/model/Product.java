package com.products.model;

public abstract class Product {
    private int id;
    private String msp;
    private String name;
    private Double price;
    private int soLuong;
    private String manufacturer;

    public Product() {
    }

    public Product(int id, String msp, String name, Double price, int soLuong, String manufacturer) {
        this.id = id;
        this.msp = msp;
        this.name = name;
        this.price = price;
        this.soLuong = soLuong;
        this.manufacturer = manufacturer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getMsp() {
        return msp;
    }

    public void setMsp(String msp) {
        this.msp = msp;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s, ", id, msp, name, price, soLuong, manufacturer);
    }
}
