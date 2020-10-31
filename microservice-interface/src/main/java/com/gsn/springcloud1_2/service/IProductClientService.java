package com.gsn.springcloud1_2.service;


import com.gsn.springcloud1_2.bean.Book;
import com.gsn.springcloud1_2.config.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


//此处接口中的方法与服务提供方的功能( ProductController )一致
//即将 Rest的调用转为了接口中方法的调用. 这个接口中的调用要与提供方的服务要完全一样.
@FeignClient(name="microservice-provider",
        configuration = FeignClientConfig.class,
        fallbackFactory = IProductClientServiceFallbackFactory.class)  // 配置要按自定义的类FeignClientConfig
//通过  fallbackFactory 指定这个接口如访问不到怎么处理
public interface IProductClientService {

    @RequestMapping("/book/{id}") //这个springMVC的调用地址要与服务提供方要求的完全一样
    public Book get(@PathVariable("id")long id);

    @RequestMapping("/book/getAll")
    public List<Book> list() ;


}
