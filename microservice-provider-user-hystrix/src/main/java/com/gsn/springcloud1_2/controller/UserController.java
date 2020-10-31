package com.gsn.springcloud1_2.controller;


import com.gsn.springcloud1_2.bean.User1;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/get/{name}")
    @HystrixCommand(fallbackMethod="errorCallBack")   //模仿没有这个数据时，服务降级
    public  Object get(@PathVariable("name")String name) {
        User1 users = new User1();
        users.setName(name);
        users.setAge(18);
        users.setSex("F");
        return users;
    }

    //指定一个降级的方法
    public Object errorCallBack(  @PathVariable("name") String name   ){
//        Book b=new Book();
//        b.setBookId(id);
//        b.setBookName("查无此书,服务忙");
        return "查无此人，用户不可用";
    }
}

