package com.ss17_BinaryFile_Serialization.bai_tap.ManageProductToBinary;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ManageProductToBinary {
    private static final String path="src/com/ss17_BinaryFile_Serialization/data/result.txt";

    public static void main(String[] args) {
        Product product=new Product(1, "iPhone","Apple", 1999,"ABC");
        //tạo field và dùng getClass trả về tên class đó và getDeclaredFields là trả về các trường k bao gồm trường kế thừa
        //phương thức getName() ở đây là phương thức lấy tên các trường trong class đó
        /*Field[] f=product.getClass().getDeclaredFields();
        for (int i = 0; i < f.length; i++) {
            System.out.println(f[i].getName());
        }*/
        try{
            addProductToBinary(new Product(3,"new","new",1234,"BCD"));
            addProductToBinary(new Product(4,"new1","new1",2000,"DCA"));
            addProductToBinary(new Product(5,"new2","new2",1000,"BBD"));
            readProductFromBinary();
            System.out.println(searchProductByName("iPhone"));
            System.out.println(searchProductByName("new"));
            System.out.println(searchProductByName("new3"));
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    private static void addProductToBinary(Product product) throws IOException {
        if (!Files.exists(Paths.get(path))){
            Files.createFile(Paths.get(path));
        }
        ProductDAO dao=ProductDAO.getInstance();
        dao.add(product);
        FileOutputStream fileOutputStream=new FileOutputStream(path);
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(dao.listAll());
        objectOutputStream.close();
    }
    private static void readProductFromBinary() throws IOException,ClassNotFoundException {
        FileInputStream fis=new FileInputStream(path);
        ObjectInputStream ois=new ObjectInputStream(fis);
        List<Product> li= (List<Product>) ois.readObject();
        li.stream().forEach(product -> {
            System.out.println(product.getName());
        });
    }
    private static boolean searchProductByName(String name){
        ProductDAO dao=ProductDAO.getInstance();
        return dao.searchByName(name);
    }
}
