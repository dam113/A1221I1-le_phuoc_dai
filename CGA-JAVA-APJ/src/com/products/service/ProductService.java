package com.products.service;

import com.products.exception.NotFoundException;
import com.products.model.AuthenticProduct;
import com.products.model.HandProduct;
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

    public void create(Product product){
        //region get last id
        int lastId = 0;

        if(products.size()> 0){
            lastId= products.get(products.size()-1).getId();
        }
        //endregion

        product.setId(lastId + 1);

        products.add(product);
        fileHelper.write(ConstantUtil.PRODUCT_PATH, Collections.singletonList(product), true);
    }

    public List findAll(){
        return products;
    }

    public void delete(int id) throws NotFoundException{
        if(!products.removeIf(e-> e.getId() == id)){
            throw new NotFoundException("ID " + id + " cound not found. ");
        }

        fileHelper.write(ConstantUtil.PRODUCT_PATH, products, false);
    }

    public List searchByName(String name){
        List result = new ArrayList();
        for (int i = 0; i < products.size(); i++) {
            if(products.get(i).getName().contains(name)){
                result.add(products.get(i));
            }
        }

        return  result;
    }

    private List mapToProducts(){
        List result = new ArrayList();
        List<String> lines = fileHelper.read(ConstantUtil.PRODUCT_PATH);
        for (String line : lines){
            String[] tmp = line.split(",");
            int id = Integer.parseInt(tmp[0]);
            String name = tmp[1];
            double price = Double.parseDouble(tmp[2]);
            String manufacturer= tmp[3];

            Product product;
            if(tmp.length == 5){
                int granteeByYear = Integer.parseInt(tmp[4]);
                product = new AuthenticProduct(id, name, price, manufacturer, granteeByYear);
            }
            else{
                String country = tmp[4];
                String status = tmp[5];
                product = new HandProduct(id, name, price, manufacturer, country, status);
            }

            result.add(product);
        }

        return result;
    }
}
