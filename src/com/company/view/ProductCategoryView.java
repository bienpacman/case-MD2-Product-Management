package com.company.view;


import com.company.controller.ProductCategoryControler;
import com.company.model.Product;
import com.company.model.ProductCategory;

import com.company.service.productcategory.ProductCategoryServiceIMPL;

import java.util.List;
import java.util.Scanner;

public class ProductCategoryView {


    ProductCategoryControler productCategoryControler = new ProductCategoryControler();
    Scanner scanner = new Scanner(System.in);
    List<ProductCategory> productCategoryList = ProductCategoryServiceIMPL.productCategoryList;


    public void formCreateProductCatagory() {
        while (true) {

            int id ;
            if (productCategoryList.size() == 0) {
                id = 1;
            } else {
                id = productCategoryList.get(productCategoryList.size() - 1).getId() + 1;
            }
            System.out.println("Nhập tên danh mục: ");
            String name = scanner.nextLine();


            ProductCategory productCategory1 = new ProductCategory(id, name);
            productCategoryControler.creatProductCategory(productCategory1);
            System.out.println(productCategoryControler.showListProductCategory());
            System.out.println("Nhập bất kỳ phím nào để tiếp tục tạo Danh mục sản phẩm hoặc Nhập QUIT để quay lại menu: ");
            String backMenu = scanner.nextLine();
            if (backMenu.equalsIgnoreCase("quit")) {
                new Main();
            }
        }
    }


    public void formListProductCategory() {


        for (int i = 0; i < productCategoryControler.showListProductCategory().size(); i++) {

            System.out.println(productCategoryControler.showListProductCategory().get(i).getName());

            for (int j = 0; j < productCategoryControler.findProductbyName(productCategoryControler.showListProductCategory().get(i).getName()).size() ; j++) {

                System.out.println(productCategoryControler.findProductbyName(productCategoryControler.showListProductCategory().get(i).getName()).get(j));
            }

        }
        System.out.println("NHập quit để quay lại MENU: ");
        String backMenu = scanner.nextLine();
        if (backMenu.equalsIgnoreCase("quit")) {
            new Main();
        }
    }


    public void formDeleteProductCatagory() {
        while (true) {
            System.out.println(productCategoryControler.showListProductCategory());
            System.out.println("Nhap ID muon xoa:");
            int id = scanner.nextInt();
            productCategoryControler.delteteByID(id);
            productCategoryControler.showListProductCategory();
            scanner.nextLine();
            System.out.println("Nhập bất kỳ phím nào để tiếp tục xóa Danh mục sản phẩm hoặc Nhập QUIT để quay lại menu: ");
            String backMenu = scanner.nextLine();
            if (backMenu.equalsIgnoreCase("quit")) {
                new Main();
            }
        }

    }
    public void showProductByCatagoruName(){

        productCategoryControler.sortProductCatagory();
        System.out.println(productCategoryControler.showListProductCategory());
        System.out.println(" Nhập quit để quay lại MENU: ");
        String backMenu = scanner.nextLine();
        if (backMenu.equalsIgnoreCase("quit")) {
            new Main();
        }

    }

    public void editById() {
        while (true) {
            System.out.println(productCategoryControler.showListProductCategory());
            System.out.println("Nhập ID muốn sửa:");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Nhập tên danh mục: ");
            String name = scanner.nextLine();
            ProductCategory productCategory = new ProductCategory(id, name);
            productCategoryControler.editById(productCategory);
            System.out.println(productCategoryControler.showListProductCategory());
            System.out.println("Nhập bất kỳ phím nào để tiếp tục chỉnh sửa Danh mục sản phẩm hoặc Nhập QUIT để quay lại menu: ");
            String backMenu = scanner.nextLine();
            if (backMenu.equalsIgnoreCase("quit")) {
                new Main();
            }
        }
    }



}