package com.company.view;


import com.company.model.Role;
import com.company.model.RoleName;
import com.company.model.UserPrincipal;
import com.company.service.userprincipal.UserPrincipalIMPL;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public Main(){


        if (UserPrincipalIMPL.userPrincipalList.size()==0){
            new RegisterAndLoginView();

        }
        List<UserPrincipal> userPrincipalList= UserPrincipalIMPL.userPrincipalList;
        boolean checklogin=false;
        Set<Role> roleSet=userPrincipalList.get(0).getRoleSet();
        List<Role> roleList=new ArrayList<>(roleSet);

        boolean checkAdmin=roleList.get(0).getName()== RoleName.ADMIN;
        boolean checkAdmin1=roleList.get(0).getName()== RoleName.PM;
        if (userPrincipalList.size()!=0){
            checklogin=true;
        }else  checklogin=false;
        Scanner scanner=new Scanner(System.in);
        System.out.println("============NHƯỜI DÙNG ĐĂNG NHẬP===============");
        if (checklogin){
            System.out.println("3. HIỂN THỊ DANH SÁCH PHÂN QUYỀN");
            System.out.println("4. HỒ SƠ");
            System.out.println("5. SẮP XẾP SẢN PHẨM THEO GIÁ");
            System.out.println("6. TÌM SẢN PHẨM THEO TÊN");
            System.out.println("7.MUA SẢN PHẨM ");
            System.out.println("8.Tìm SẢN PHẨM theo TÊN DANH MỤC ");
            System.out.println("9.Tìm SẢN PHẨM theo giá ");
            System.out.println("10. ");



            if (checkAdmin||checkAdmin1){
                System.out.println("==================QUẢN LÝ SẢN PHẨM=====================");
                System.out.println("11. DANH SÁCH NGƯỜI DÙNG XEM");
                System.out.println("12. THÊM SẢN PHẨM");
                System.out.println("13. HIỂN THỊ DANH SÁCH SẢN PHẨM");
                System.out.println("14. XÓA SẢN PHẨM THEO ID");
                System.out.println("15. SỬA SẢN PHẨM THEO ID");
                System.out.println("16. SẮP XẾP SẢN PHẨM THEO TÊN");
                System.out.println("17. THÊM DANH MỤC ");
                System.out.println("18. HIỂN THỊ DANH MỤC ");
                System.out.println("19. XÓA DANH MỤC ");
                System.out.println("20. SỬA DANH MỤC THEO ID");
                System.out.println("21. HIỂN THỊ DANH SÁCH SẢN PHẨM");
                System.out.println("22. THOÁT RA");
            }
        }else {
            System.out.println("1. Tạo tài khoản");
            System.out.println("2. Đăng nhập");
        }

        System.out.println("Nhập số: ");
        int chooseMenu=scanner.nextInt();
        switch (chooseMenu){
            case 1:
                new RegisterView().register();
                break;
            case 2:
                new LoginView();
                break;
            case 3:
                new RoleView().showListRole();
                break;
            case 4:
                new ProfileView();
                break;

            case 5:
                new ProductView().sortByPrice();
                break;

            case 6:
                new ProductView().findProductByName();
                break;

            case 7:
                new BuyProductView().createBuyProduct();
                break;

            case 8:
                new ProductView().findProductByCatarogyName();
                break;
            case 9:
                new ProductView().findProductByPriceFrom();
                break;

            case 10:
                new BuyProductView().productBest();
                break;

            case 11:
                if (checkAdmin||checkAdmin1){
                    new ListUserView();
                }else {
                    System.out.println("Không đủ quyền truy cập");
                    new Main();
                }
            case 12:
                new ProductView().createProduct();
                break;

            case 13:
                new ProductView().showListProduct();
                break;

            case 14:
                new ProductView().formDelete();
                break;

            case 15:
                new ProductView().editById();
                break;

            case 16:
                new ProductView().sortByName();
                break;

            case 17:
                new ProductCategoryView().formCreateProductCatagory();
                break;
            case 18:
                new ProductCategoryView().showProductByCatagoruName();

            case 19:
                new ProductCategoryView().formDeleteProductCatagory();
                break;
            case 20:
                new ProductCategoryView().editById();
                break;
            case 21:
                new BuyProductView().showListBuyProduct();
                break;
            case 22:
                new ProfileView();
                break;
        }

    }
    public static void main(String[] args) {

        new Main();
    }
}