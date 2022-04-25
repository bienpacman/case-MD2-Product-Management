package com.company.controller;

import com.company.model.Role;
import com.company.service.role.RoleServiceIMPL;

import java.util.List;

public class RoleControler {
    RoleServiceIMPL roleServiceIMPL=new RoleServiceIMPL();
    public List<Role> showListRole(){
        return roleServiceIMPL.findAll();
    }
}