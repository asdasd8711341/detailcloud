package com.gsn.springcloud1_2.bean;



import lombok.Data;

import java.io.Serializable;

@Data
public class User1 implements Serializable {
    private String name;
    private int age;
    private String sex;
}
