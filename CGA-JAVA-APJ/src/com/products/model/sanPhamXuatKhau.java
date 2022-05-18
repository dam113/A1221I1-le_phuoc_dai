package com.products.model;

public class sanPhamXuatKhau extends Product {
    private Double giaXuatKhau;
    private String quocGiaNhapSanPham;

    public sanPhamXuatKhau(Double giaXuatKhau, String quocGiaXuatKhau) {
        this.giaXuatKhau = giaXuatKhau;
        this.quocGiaNhapSanPham = quocGiaXuatKhau;
    }

    public sanPhamXuatKhau(int id, String msp, String name, Double price, int soLuong, String manufacturer, Double giaXuatKhau, String quocGiaXuatKhau) {
        super(id, msp, name, price, soLuong, manufacturer);
        this.giaXuatKhau = giaXuatKhau;
        this.quocGiaNhapSanPham = quocGiaXuatKhau;
    }

    public Double getGiaXuatKhau() {
        return giaXuatKhau;
    }

    public void setGiaXuatKhau(Double giaXuatKhau) {
        this.giaXuatKhau = giaXuatKhau;
    }

    public String getQuocGiaNhapSanPham() {
        return quocGiaNhapSanPham;
    }

    public void setQuocGiaNhapSanPham(String quocGiaNhapSanPham) {
        this.quocGiaNhapSanPham = quocGiaNhapSanPham;
    }

    @Override
    public String toString() {
        return super.toString() + giaXuatKhau + "," + quocGiaNhapSanPham;
    }
}
