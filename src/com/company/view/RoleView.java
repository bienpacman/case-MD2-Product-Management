package com.company.view;


import com.company.controller.RoleControler;

import java.util.Scanner;

public class RoleView {
    Scanner scanner = new Scanner(System.in);
    RoleControler roleControler = new RoleControler();

    public void showListRole() {
        System.out.println(roleControler.showListRole());
        System.out.println("Nhập quit để trở về MENU: ");
        String backMenu = scanner.nextLine();
        if (backMenu.equalsIgnoreCase("quit")) {
            new Main();
        }
    }
}