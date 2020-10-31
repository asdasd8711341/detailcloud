package com.gsn.springcloud1_2.bean;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name="user")
public class User {
    @Id
    private Integer uid;
    private String username;
    private String password;
    private String roles;


}
