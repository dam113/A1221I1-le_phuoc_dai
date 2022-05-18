package com.products.service;

import com.products.exception.NotFoundException;
import com.products.model.sanPhamXuatKhau;
import com.products.model.sanPhamNhapKhau;
import com.products.model.Product;
import com.products.util.FileHelper;
import com.products.util.ConstantUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductService {
    private List<Product> products;
    private FileHelper fileHelper = new FileHelper();

    public ProductService() {
        products = mapToProducts();
    }

    public void create(Product product) {
        //region get last id
        int lastId = 0;

        if (products.size() > 0) {
            lastId = products.get(products.size() - 1).getId();
        }
        //endregion

        product.setId(lastId + 1);

        products.add(product);
        fileHelper.write(ConstantUtil.PRODUCT_PATH, Collections.singletonList(product), true);
    }

    public List findAll() {
        return products;
    }

    public void delete(String msp) throws NotFoundException {
        if (!products.removeIf(e -> e.getMsp().equals(msp))) {
            throw new NotFoundException("ID " + msp + " cound not found. ");
        }

        fileHelper.write(ConstantUtil.PRODUCT_PATH, products, false);
    }

    public List searchByName(String name) {
        List result = new ArrayList();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getName().contains(name)) {
                result.add(products.get(i));
            }
        }

        return result;
    }

    private List mapToProducts() {
        List result = new ArrayList();
        List<String> lines = fileHelper.read(ConstantUtil.PRODUCT_PATH);
        for (String line : lines) {
            String[] tmp = line.split(",");
            int id = Integer.parseInt(tmp[0]);
            String msp = tmp[1];
            String name = tmp[2];
            double price = Double.parseDouble(tmp[3]);
            int soLuong = Integer.parseInt(tmp[4]);
            String manufacturer = tmp[5];

            Product product;
            if (tmp.length == 8) {
                Double priceXK = Double.parseDouble(tmp[6]);
                String quocGia = tmp[7];
                product = new sanPhamXuatKhau(id, msp, name, price, soLuong, manufacturer, priceXK, quocGia);
            } else {
                Double priceNK = Double.parseDouble(tmp[6]);
                String tinhThanh = tmp[7];
                Double thue = Double.parseDouble(tmp[8]);
                product = new sanPhamNhapKhau(id, msp, name, price, soLuong, manufacturer, priceNK, tinhThanh, thue);
            }

            result.add(product);
        }

        return result;
    }
}
