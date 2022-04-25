package com.company.view;

import com.company.controller.UserControler;
import com.company.dto.SignUpDTO;
import com.company.service.role.RoleServiceIMPL;
import com.company.service.user.UserServiceIMPL;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;

public class RegisterView {
    Scanner scanner=new Scanner(System.in);
    UserControler userControler=new UserControler();
    UserServiceIMPL userServiceIMPL=new UserServiceIMPL();
    public void register(){
        new RoleServiceIMPL().findAll();
        System.out.println("Nhập tên của bạn: ");
        String name=scanner.nextLine();
        System.out.println("Nhập tên đăng nhập: ");
        String username;
        boolean checkUserName;
        while (true){
            username=scanner.nextLine();
            checkUserName= Pattern.matches("[a-z0-9_-]{6,}",username);
            if (!checkUserName) {
                System.out.println("UserName failed! please try again!");
                new RegisterAndLoginView();

            }else if (userServiceIMPL.existedByUsername(username)){
                System.out.println("username is existed!try again!");
                new RegisterAndLoginView();
            }else break;
        }
        System.out.println("Nhập mật khẩu: ");
        String password=scanner.nextLine();
        System.out.println("Nhập phân quyền");
        String role=scanner.nextLine();
        Set<String> strRole=new HashSet<>();
        strRole.add(role);
        SignUpDTO signUpDTO=new SignUpDTO(name,username,password,strRole);
        userControler.register(signUpDTO);

        new LoginView();

    }
}