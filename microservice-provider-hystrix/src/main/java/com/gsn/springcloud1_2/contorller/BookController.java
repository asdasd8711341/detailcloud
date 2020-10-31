package com.gsn.springcloud1_2.contorller;


import com.gsn.springcloud1_2.bean.Book;
import com.gsn.springcloud1_2.service.BookService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping("book")

public class BookController {


    @Autowired
    private BookService bookService;

    @Resource
    private DiscoveryClient discoveryClient;   //注意要导入springframework中的接口

    @GetMapping("{id}")
    @HystrixCommand(fallbackMethod="errorCallBack")   //模仿没有这个数据时，服务降级
    public Object getBook(@PathVariable("id") Integer id){
        show();
        Book b=bookService.getBook(id);
        if( b==null ){
            throw new RuntimeException("查无此产品");
        }
        return b;
    }

    //指定一个降级的方法
    public Object errorCallBack(  @PathVariable("id") Integer id   ){
//        Book b=new Book();
//        b.setBookId(id);
//        b.setBookName("查无此书,服务忙");
        return "查无此书，服务忙";
    }


    @GetMapping("getAll")
    public List<Book> getAll(){

        show();
        return  bookService.getAll();
    }

    private void show(){
        System.out.println( this.discoveryClient.description() );

        //EurekaDiscoveryClient
        EurekaDiscoveryClient edc=(EurekaDiscoveryClient)this.discoveryClient;
        // 服务器上有有很多服务
        List<String> servicesName=edc.getServices();
        for( String sn:servicesName ){
            System.out.println("服务名:"+ sn );
            List<ServiceInstance> instances=edc.getInstances(  sn );
            for(  ServiceInstance si:instances ){
                System.out.println(  si.getScheme()+" "+  si.getHost() +" "+si.getPort()+" "+ si.getUri()  );
            }
        }
    }

}
