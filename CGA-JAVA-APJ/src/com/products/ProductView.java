package com.products;

import com.products.exception.NotFoundException;
import com.products.model.sanPhamXuatKhau;
import com.products.model.sanPhamNhapKhau;
import com.products.model.Product;
import com.products.service.ProductService;
import com.products.validation.Validation;

import java.util.List;
import java.util.Scanner;

public class ProductView {
    private static final Scanner input = new Scanner(System.in);
    private static final ProductService productService = new ProductService();

    public static void main(String[] args) {
        while (true) {
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
        String name = input.nextLine();
        List<Product> products = productService.searchByName(name);
        for (Product product : products) {
            System.out.println(product);
        }
    }

    private static void display() {
        List<Product> products = productService.findAll();
        if (products.size() > 0) {
            for (Product product : products) {
                if (product instanceof sanPhamXuatKhau) {
                    System.out.printf("Sản phẩm xuất khẩu: id=%s, msp=%s, name=%s, price=%s, soLuong=%s, manufacturer=%s, giaXuatKhau=%s, quocGiaNhap=%s \n"
                            , product.getId(), product.getMsp(), product.getName(), product.getPrice(), product.getSoLuong(), product.getManufacturer(), ((sanPhamXuatKhau) product).getGiaXuatKhau(), ((sanPhamXuatKhau) product).getQuocGiaNhapSanPham());
                } else {
                    System.out.printf("Sản phẩm nhập khẩu: id=%s, msp=%s, name=%s, price=%s, soLuong=%s, manufacturer=%s, giaNhapSP=%s, tinhThanh=%s, thueNhapKhau=%s \n"
                            , product.getId(), product.getMsp(), product.getName(), product.getPrice(), product.getSoLuong(), product.getManufacturer(), ((sanPhamNhapKhau) product).getPriceNhapKhau(), ((sanPhamNhapKhau) product).getCountry(), ((sanPhamNhapKhau) product).getThueNhapKhau());
                }
            }
        } else {
            System.out.println("Product List is empty");
        }
    }

    private static void delete() {
        display();
        System.out.print("Enter product code to delete:");

        boolean isExist;
        do {
            try {
                String msp = input.nextLine();
                System.out.println("Bạn có chắc chắn muốn xóa? (Y/N)");
                String check = input.nextLine();
                if (check.equals("Y")) {
                    productService.delete(msp);
                    System.out.println("Deleted successfully");
                } else {
                    display();
                }

                isExist = false;
            } catch (NotFoundException e) {
                System.out.print(e.getMessage() + "Please input again:");
                isExist = true;
            }
        } while (isExist);

    }

    private static void create() {
        System.out.println("Choice product to create:");
        System.out.println("1. Sản phẩm nhập khẩu");
        System.out.println("2. Sản phẩm xuất khẩu");
        int choose = yourChoice();
        String msp = inputWithoutEmpty("msp");
        String name = inputWithoutEmpty("name");

        String price = "";
        do {
            System.out.print(price.isEmpty() ? "Input price:" : "Price have to greater than 10000. Input again: ");
            price = input.nextLine();
        } while (!Validation.validPrice(price));

        String soLuong = "";
        do {
            System.out.print(soLuong.isEmpty() ? "Input số lương:" : "số lượng have to greater than 50. Input again: ");
            soLuong = input.nextLine();
        } while (!Validation.validSoLuong(soLuong));


        String manufacturer = inputWithoutEmpty("manufacturer");

        Product product;
        if (choose == 1) {
            String priceXK = "";
            do {
                System.out.print(priceXK.isEmpty() ? "Giá Xuất khẩu:" : "Price have to greater than 10000. Input again: ");
                priceXK = input.nextLine();
            } while (!Validation.validPrice(priceXK));
            System.out.print("Quốc gia nhập sản phẩm:");
            String quocGia = input.nextLine();
            product = new sanPhamXuatKhau(0, msp, name, Double.parseDouble(price), Integer.parseInt(soLuong), manufacturer, Double.parseDouble(priceXK), quocGia);

        } else {
            String priceNK = "";
            do {
                System.out.print(priceNK.isEmpty() ? "Giá Xuất khẩu:" : "Price have to greater than 10000. Input again: ");
                priceNK = input.nextLine();
            } while (!Validation.validPrice(priceNK));
            System.out.print("Tỉnh thành nhập sản phẩm:");
            String tinhThanh = input.nextLine();
            String thue = "";
            do {
                System.out.print(thue.isEmpty() ? "thuế:" : "Price have to greater than 10000. Input again: ");
                thue = input.nextLine();
            } while (!Validation.validPrice(thue));
            product = new sanPhamNhapKhau(0, msp, name, Double.parseDouble(price), Integer.parseInt(soLuong), manufacturer, Double.parseDouble(priceNK), tinhThanh, Double.parseDouble(thue));

        }

        productService.create(product);
        System.out.println("Created successfully");
    }

    private static int yourChoice() {
        System.out.print("Enter your choice:");
        return Integer.parseInt(input.nextLine());
    }

    private static String inputWithoutEmpty(String fieldName) {
        String result = "0";
        do {
            System.out.print(result.isEmpty() ? fieldName.toUpperCase() + " cannot empty. Input again:" : "Input " + fieldName + ":");
            result = input.nextLine();
        }
        while (result.isEmpty());

        return result;
    }
}
