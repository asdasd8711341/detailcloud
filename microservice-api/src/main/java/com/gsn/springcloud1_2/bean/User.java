package com.gsn.springcloud1_2.bean;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

//@Data
@Table(name="user")
public class User {
    @Id
    private Integer uid;
    private String username;
    private String password;
    private String roles;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
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

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
}
