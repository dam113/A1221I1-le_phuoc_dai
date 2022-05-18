package com.products.model;

public class sanPhamNhapKhau extends Product {
    private Double priceNhapKhau;
    private String country;
    private Double thueNhapKhau;

    public sanPhamNhapKhau(Double priceNhapKhau, String country, Double thueNhapKhau) {
        this.priceNhapKhau = priceNhapKhau;
        this.country = country;
        this.thueNhapKhau = thueNhapKhau;
    }

    public sanPhamNhapKhau(int id, String msp, String name, Double price, int soLuong, String manufacturer, Double priceNhapKhau, String country, Double thueNhapKhau) {
        super(id, msp, name, price, soLuong, manufacturer);
        this.priceNhapKhau = priceNhapKhau;
        this.country = country;
        this.thueNhapKhau = thueNhapKhau;
    }

    public Double getPriceNhapKhau() {
        return priceNhapKhau;
    }

    public void setPriceNhapKhau(Double priceNhapKhau) {
        this.priceNhapKhau = priceNhapKhau;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Double getThueNhapKhau() {
        return thueNhapKhau;
    }

    public void setThueNhapKhau(Double thueNhapKhau) {
        this.thueNhapKhau = thueNhapKhau;
    }

    @Override
    public String toString() {
        return super.toString() + priceNhapKhau + "," + country + "," + thueNhapKhau;
    }
}
