package com.ss17_BinaryFile_Serialization.bai_tap.ManageProductToBinary;

import java.util.ArrayList;
import java.util.List;

class ProductDAO {
    private static ProductDAO instance;
    private static List<Product> data=new ArrayList<>();
    static {
        data.add(new Product(1, "iPhone X","Apple", 999,"Mô tả"));
        data.add(new Product(2, "XBOX 360", "Microsoft",400,"Diễn tả"));
    }

    public static ProductDAO getInstance() {
        if (instance==null){
            instance=new ProductDAO();
        }
        return instance;
    }

    public static void setInstance(ProductDAO instance) {
        ProductDAO.instance = instance;
    }

    public ProductDAO() {
    }
    public List<Product> listAll() {
        return new ArrayList<Product>(data);
    }
    public int add(Product product){
        int newId= data.size()+1;
        product.setId(newId);
        data.add(product);
        return newId;
    }
    public Product get(int id){
        Product productFind=new Product(id);
        int index=data.indexOf(productFind);
        if (index>=0){
            return data.get(index);
        }
        return null;
    }
    public boolean searchByName(String name){
        return data.stream().anyMatch(p -> p.getName().contains(name));
    }
    public boolean delete(int id){
        Product productFind=new Product(id);
        int index=data.indexOf(productFind);
        if(index>=0){
            data.remove(index);
            return true;
        }
        return false;
    }
    public boolean update(Product product){
        int index=data.indexOf(product);
        if (index>=0){
            data.set(index,product);
            return true;
        }
        return false;
    }
}
