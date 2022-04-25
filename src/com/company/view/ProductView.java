package com.company.view;


import com.company.controller.ProductCategoryControler;
import com.company.controller.ProductControler;
import com.company.model.Product;
import com.company.model.ProductCategory;

import com.company.service.product.ProductServiceIMPL;

import java.util.List;
import java.util.Scanner;

public class ProductView {

    Scanner scanner = new Scanner(System.in);
    ProductControler productControler = new ProductControler();
    ProductCategoryControler productCategoryControler = new ProductCategoryControler();
    List<Product> productList = ProductServiceIMPL.productList;

    public void createProduct() {
        while (true) {
            int id;
            if (ProductServiceIMPL.productList.size() == 0) {
                id = 1;
            } else {
                id = productList.get(productList.size() - 1).getId() + 1;
            }
            System.out.println("Nhập tên sản phẩm: ");
            String name = scanner.nextLine();
            System.out.println("Nhập xuất xứ sản phẩm: ");
            String productFrom = scanner.nextLine();
            System.out.println("Nhập giá sản phẩm: ");
            float price = Float.parseFloat(scanner.nextLine());
            System.out.println("Nhập id danh mục: ");
            int idPrductCatagory=Integer.parseInt(scanner.nextLine());
;
            ProductCategory productCategory=new ProductCategoryControler().findById(idPrductCatagory);
            Product product = new Product(id, name, productFrom, price, productCategory);
            productControler.creatProduct(product);
            System.out.println("Nhập phím bất kỳ để tiếp tục tạo Sản phẩm hoặc Nhập QUIT để quay lại menu: ");
            String backMenu = scanner.nextLine();
            if (backMenu.equalsIgnoreCase("quit")) {
                new Main();
            }
        }
    }

    public void showListProduct() {
        System.out.println(productControler.showListProduct());
        System.out.println("Nhập quit để trở về Menu ");
        String backMenu = scanner.nextLine();
        if (backMenu.equalsIgnoreCase("quit")) {
            new Main();
        }
    }

    public void formDelete() {
        System.out.println(productControler.showListProduct());
        System.out.println("Nhap ID muon xoa:");

        if (productList.size() != 0) {
            int id = scanner.nextInt();
            productControler.deleteById(id);
        } else {
            System.out.println("Không có gì để xóa!");
            new Main();
        }

        System.out.println(productControler.showListProduct());
        System.out.println("Nhập phím bất kỳ để tiếp tục tạo Sản phẩm hoặc Nhập QUIT để quay lại menu: ");
        scanner.nextLine();
        String backMenu = scanner.nextLine();
        if (backMenu.equalsIgnoreCase("quit")) {
            new Main();
        }
    }

//    public void findAmountProductByCatarogyName() {
//        while (true) {
//            System.out.println("Enter name of Catarogy");
//            String ProductCatarogyName = scanner.nextLine();
//            ProductCategory productCategory=new ProductCategory(ProductCatarogyName);
//            productControler.findAmountProductByCatagory(productCategory);
//            System.out.println("Enter any key to continue or Enter QUIT to come back menu: ");
//            String backMenu = scanner.nextLine();
//            if (backMenu.equalsIgnoreCase("quit")) {
//                new Main();
//            }
//        }
//
//    }

    public void editById() {
        while (true) {
            System.out.println(productControler.showListProduct());
            System.out.println("Nhập id muốn sửa:");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Nhập tên muốn sửa sản phẩm: ");
            String name = scanner.nextLine();
            System.out.println("Nhập xuất xứ muốn sửa:");
            String productFrom = scanner.nextLine();
            System.out.println("Nhập giá muốn sửa:");
            float price = Float.parseFloat(scanner.nextLine());
            System.out.println("NHập danh mục muốn sửa:");
            String ProductCatarogyName = scanner.nextLine();
//            ProductCategory productCategory=new ProductCategory(ProductCatarogyName);
//            Product product = new Product(id, name, productFrom, price, productCategory);
//            productControler.editById(product);
            System.out.println(productControler.showListProduct());
            System.out.println("Nhập phím bất kỳ để tiếp tục tạo Sản phẩm hoặc Nhập QUIT để quay lại menu: ");
            String backMenu = scanner.nextLine();
            if (backMenu.equalsIgnoreCase("quit")) {
                new Main();
            }
        }
    }

    public void findProductByPriceFrom() {
        while (true){
            System.out.println("1. Tìm giá từ 0 ~ 5000");
            System.out.println("2. Tìm giá từ 5000 ~ 10000");
            System.out.println("3. Tìm giá từ 10000 ~ 100000");
            System.out.println("Nhập một lựa chọn");
            int choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    productControler.findProductByPrice1();
                    System.out.println("Nhập phím bất kỳ để tiếp tục tạo Sản phẩm hoặc Nhập QUIT để quay lại menu :");
                    scanner.nextLine();
                    String backMenu = scanner.nextLine();
                    if (backMenu.equalsIgnoreCase("quit")) {
                        new Main();
                    }
                    break;


                case 2:
                    productControler.findProductByPrice2();
                    System.out.println("Nhập phím bất kỳ để tiếp tục tạo Sản phẩm hoặc Nhập QUIT để quay lại menu: ");
                    scanner.nextLine();
                    String backMenu1 = scanner.nextLine();
                    if (backMenu1.equalsIgnoreCase("quit")) {
                        new Main();
                    }
                    break;


                case 3:
                    productControler.findProductByPrice3();
                    System.out.println("Nhập phím bất kỳ để tiếp tục tạo Sản phẩm hoặc Nhập QUIT để quay lại menu: ");
                    scanner.nextLine();
                    String backMenu2 = scanner.nextLine();
                    if (backMenu2.equalsIgnoreCase("quit")) {
                        new Main();
                    }
                    break;
            }
        }
    }

    public void sortByName() {
        System.out.println("List trước khi sửa");
        System.out.println(productControler.showListProduct());
        productControler.sortByName();
        System.out.println("List sau khi sửa");
        System.out.println(productControler.showListProduct());
        System.out.println("Nhập phím bất kỳ để tiếp tục tạo Sản phẩm hoặc Nhập QUIT để quay lại menu: ");
        String backMenu = scanner.nextLine();
        if (backMenu.equalsIgnoreCase("quit")) {
            new Main();
        }

    }

    public void sortByPrice() {
        System.out.println("List trước khi sửa");
        System.out.println(productControler.showListProduct());
        productControler.sortByPrice();
        System.out.println("List sau khi sửa");
        System.out.println(productControler.showListProduct());
        System.out.println("Nhập phím bất kỳ để tiếp tục tạo Sản phẩm hoặc Nhập QUIT để quay lại menu: ");
        String backMenu = scanner.nextLine();
        if (backMenu.equalsIgnoreCase("quit")) {
            new Main();
        }

    }
    public void findProductByName() {
        System.out.println("Nhap ten can tim: ");
        String name = scanner.nextLine();
        if (productControler.findProductByName(name) != null) {
            System.out.println(productControler.findProductByName(name));
        } else System.out.println("Không tồn tại sản phẩm");
        System.out.println("Nhập phím bất kỳ để tiếp tục tạo Sản phẩm hoặc Nhập QUIT để quay lại menu: ");
        String backMenu = scanner.nextLine();
        if (backMenu.equalsIgnoreCase("quit")) {
            new Main();
        }
    }
    public void findProductByCatarogyName(){
        System.out.println("Nhập tên cần tìm: ");
        String name = scanner.nextLine();
        productControler.findProductByCatagoryName(name);
        System.out.println("Nhập phím bất kỳ để tiếp tục hoặc Nhập QUIT để quay lại menu: ");
        String backMenu = scanner.nextLine();
        if (backMenu.equalsIgnoreCase("quit")) {
            new Main();
        }

    }
}