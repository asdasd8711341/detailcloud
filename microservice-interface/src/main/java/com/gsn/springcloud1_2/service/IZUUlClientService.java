package com.gsn.springcloud1_2.service;

import com.gsn.springcloud1_2.bean.Book;
import com.gsn.springcloud1_2.bean.User1;
import com.gsn.springcloud1_2.config.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * feign访问zuul的接口
 */
@FeignClient(name="MICROSERVICE-ZUUL-GATEWAY",configuration = FeignClientConfig.class,fallbackFactory = IZuulClientServiceCallbackFactory.class)
public interface IZUUlClientService {

    @RequestMapping("/yc-api/product-proxy/book/{id}")
    public Book getBook(@PathVariable("id")long id);

    @RequestMapping("/yc-api/product-proxy/book/getAll")
    public List<Book> getAll();

    @RequestMapping("/yc-api/user1-proxy/user/get/{name}")
    public User1 getUser(@PathVariable("name")String name);

    @RequestMapping("/yc-api/user2-proxy/user/get/{name}")
    public User1 getUser2(@PathVariable("name")String name);
}

