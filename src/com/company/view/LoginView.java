package com.company.view;


import com.company.controller.UserControler;
import com.company.dto.SIgnInDTO;

import com.company.service.user.UserServiceIMPL;

import java.util.Scanner;

public class LoginView {
    Scanner scanner = new Scanner(System.in);
    UserControler userControler = new UserControler();

    public LoginView() {
        System.out.println("ĐĂNG NHẬP");
        System.out.println("Nhập tên đăng nhập");
        String username = scanner.nextLine();
        System.out.println("Nhập mật khẩu");
        String password = scanner.nextLine();
        SIgnInDTO signInDTO = new SIgnInDTO(username, password);
        if (userControler.login(signInDTO)) {
            new ProfileView();
        } else {
            System.err.println("Đăng nhập thất bại! vui lòng kiểm tra tên người dùng hoặc mật khẩu!");
            new LoginView();
        }
    }
}