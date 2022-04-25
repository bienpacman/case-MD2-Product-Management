package com.company.view;

import com.company.controler.BuyProductControler;

import com.company.controller.ProductCategoryControler;
import com.company.controller.ProductControler;
import com.company.model.BuyProduct;
import com.company.model.Product;
import com.company.model.ProductCategory;

import com.company.service.buyproduct.BuyProductServiceIMPL;

import java.util.List;
import java.util.Scanner;

public class BuyProductView {
    Scanner scanner=new Scanner(System.in);
    BuyProductControler buyProductControler=new BuyProductControler();
    BuyProduct buyProduct=new BuyProduct();
    ProductControler productControler=new ProductControler();
    ProductCategoryControler productCategoryControler=new ProductCategoryControler();
    List<BuyProduct> buyProductList= BuyProductServiceIMPL.buyProductList;

    public void createBuyProduct()  {
        while (true){
            int count;
            if(BuyProductServiceIMPL.buyProductList.size()==0){
                count = 1;
            } else {
                count = buyProductList.get(buyProductList.size()-1).getCount()+1;
            }
            System.out.println("Nhập số lượng mua: ");
            int amount=Integer.parseInt(scanner.nextLine());
            System.out.println("Nhập ngày mua sản phẩm: ");
            String ngMua=scanner.nextLine();

            System.out.println("Nhập id sản phẩm: ");
            int idProduct =Integer.parseInt(scanner.nextLine());
            Product product=new ProductControler().findById(idProduct);
            BuyProduct buyProduct=new BuyProduct(count,ngMua,amount,product);

            buyProductControler.creatBuyProduct(buyProduct);
            System.out.println(buyProductControler.showList());
//            double total=amount*price;
//            buyProductControler.showList();
//            System.out.println("Total is: "+total);
            System.out.println("Nhập phím bất kỳ để tiếp tục tạo Sản phẩm hoặc Nhập QUIT để quay lại menu: ");
            String backMenu = scanner.nextLine();
            if(backMenu.equalsIgnoreCase("quit")){
                new Main();
            }
        }

    }
    public void productBest(){
        System.out.println("Hiển thị Sản phẩm bán chạy nhất");
        buyProductControler.bestProduct();
        System.out.println(buyProductControler.showList());
        System.out.println("Nhập phím bất kỳ để tiếp tục tạo Sản phẩm hoặc Nhập QUIT để quay lại menu: ");
        String backMenu = scanner.nextLine();
        if(backMenu.equalsIgnoreCase("quit")){
            new Main();
        }

    }

    public void showListBuyProduct()  {
        System.out.println(buyProductControler.showList());
        System.out.println("Nhập QUIT để quay lại menu: ");
        String backMenu = scanner.nextLine();
        if(backMenu.equalsIgnoreCase("quit")){
            new Main();
        }
    }


}