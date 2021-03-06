package com.company.model;

import java.io.Serializable;
import java.util.Set;

public class User implements Serializable {
    private int id;
    private String name;
    private String username;
    private String password;
    private String email;
    private String avatar;
    private Set<Role> roleset;

    public User() {
    }

    public User(int id, String name, String username, String password, String email, String avatar, Set<Role> roleset) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.avatar = avatar;
        this.roleset = roleset;
    }

    public User(int id, String name, String username, String password, Set<Role> roleset) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.roleset = roleset;
    }

    public Set<Role> getRoleset() {
        return roleset;
    }

    public void setRoleset(Set<Role> roleset) {
        this.roleset = roleset;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", avatar='" + avatar + '\'' +
                ", roleset=" + roleset +
                '}';
    }
}