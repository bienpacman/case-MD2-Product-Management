package com.company.view;

import java.util.Scanner;

public class RegisterAndLoginView {
    public RegisterAndLoginView(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("=============Form Register & Login==============");
        System.out.println("1. Tạo tài khoản :");
        System.out.println("2. Đăng nhập :");
        int choice1=scanner.nextInt();
        switch (choice1){
            case 1:
                new RegisterView().register();
                break;
            case 2:
                new LoginView();
                break;

        }
    }
}