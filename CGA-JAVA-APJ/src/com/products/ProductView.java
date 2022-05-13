package com.products;

import com.products.exception.NotFoundException;
import com.products.model.AuthenticProduct;
import com.products.model.HandProduct;
import com.products.model.Product;
import com.products.service.ProductService;
import com.products.validation.Validation;

import java.util.List;
import java.util.Scanner;

public class ProductView {
    private static Scanner scanner = new Scanner(System.in);
    private static ProductService productService = new ProductService();

    public static void main(String[] args) {
        while (true){
            System.out.println("--- Product Menu---");
            System.out.println("1. Create");
            System.out.println("2. Display");
            System.out.println("3. Delete");
            System.out.println("4. Search");
            System.out.println("5. Exit");

            int choose = yourChoice();

            switch (choose) {
                case 1:
                    create();
                    break;
                case 2:
                    display();
                    break;
                case 3:
                    delete();
                    break;
                case 4:
                    search();
                    break;
                case 5:
                    System.exit(0);
            }
        }
    }

    private static void search() {
        display();
        System.out.print("Enter name to search:");
        String name = scanner.nextLine();
        List<Product> products= productService.searchByName(name);
        for (Product product : products) {
            System.out.println(product);
        }
    }

    private static void display() {
        List<Product> products = productService.findAll();
        if(products.size() > 0){
            for (Product product : products) {
                if(product instanceof AuthenticProduct){
                    System.out.printf("Authentic Product: id= %s, name =%s, price =%s, manufacturer = %s, granteeByYear = %s\n"
                    , product.getId(), product.getName(), product.getPrice(), product.getManufacturer() , ((AuthenticProduct) product).getGranteeByYear());
                }
                else {
                    System.out.printf("Hand Product: id= %s, name =%s, price =%s, manufacturer = %s, country = %s, status = %s\n"
                            , product.getId(), product.getName(), product.getPrice(), product.getManufacturer(), ((HandProduct)product).getCountry(), ((HandProduct)product).getStatus());
                }
            }
        }
        else{
            System.out.println("Product List is empty");
        }
    }

    private static void delete() {
        display();
        System.out.print("Enter id to delete:");

        boolean isExist;
        do{
            try{
                int id = Integer.parseInt(scanner.nextLine());
                productService.delete(id);
                System.out.println("Deleted successfully");
                isExist = false;
            }
            catch(NotFoundException e){
                System.out.print(e.getMessage() + "Please input again:");
                isExist = true;
            }
        }while(isExist);

    }

    private static void create() {
        System.out.println("Choice product to create:");
        System.out.println("1. Authentic");
        System.out.println("2. Hand");
        int choose = yourChoice();

        String name = inputWithoutEmpty("name");

        String price = "";
        do{
            System.out.print(price.isEmpty() ? "Input price:" : "Price have to greater than 50. Input again: ");
            price = scanner.nextLine();
        }while (!Validation.validPrice(price));

        String manufacturer = inputWithoutEmpty("manufacturer");

        Product product;
        if (choose == 1) {
            System.out.print("Grantee by year:");
            int granteeByYear = Integer.parseInt(scanner.nextLine());
            product = new AuthenticProduct(0, name, Double.parseDouble(price), manufacturer, granteeByYear);

        } else {
            System.out.print("Country:");
            String country = scanner.nextLine();
            System.out.print("Status:");
            String status = scanner.nextLine();
            product = new HandProduct(0, name, Double.parseDouble(price), manufacturer, country, status);

        }

        productService.create(product);
        System.out.println("Created successfully");
    }

    private static int yourChoice() {
        System.out.print("Enter your choice:");
        return Integer.parseInt(scanner.nextLine());
    }

    private static String inputWithoutEmpty(String fieldName){
        String result = "0";
        do{
            System.out.print(result.isEmpty() ? fieldName.toUpperCase() + " cannot empty. Input again:" : "Input " + fieldName + ":");
            result = scanner.nextLine();
        }
        while (result.isEmpty());

        return result;
    }
}
