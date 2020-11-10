package com.gsn.springcloud1_2.controller;


import com.gsn.springcloud1_2.bean.Book;
import com.gsn.springcloud1_2.service.IProductClientService;
import com.gsn.springcloud1_2.service.IZUUlClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/consumer")
public class ConsumerBookController {
    //private  final  static  String URL = "http://localhost:8888/book/"; //通过eureka中注册服务来访问
    //直接访问eureka中的服务名即可,这样 ribbon会拉取到服务实例列表，再利用负载均衡算法获取一个服务.
//    private final static String RESTURI="http://MICROSERVICE-PROVIDER/";
    //                                   http://ip:port/
    @Resource           //注入interface中方法
    private IZUUlClientService izuulClientService;

    private static Logger log= LoggerFactory.getLogger(ConsumerBookController.class);

    @Resource
    private IProductClientService iProductClientService;

//    @Resource
//    private LoadBalancerClient loadBalancerClient;  //应为ribbon是客户端的负载均衡，所以可以在客户端记录访问的日志

//    @Autowired
//    private RestTemplate restTemplate;
//
//    @Autowired
//    private HttpHeaders httpHeaders;
//
//    @GetMapping("{id}")
//    public Book getBook(@PathVariable("id") Integer id) {
//        //return restTemplate.getForObject(URL+id,Book.class);
//        //   HttpEntity(    MultiValueMap)   ,    HttpHeaders: MultiValueMap
//        //   返回: ResponseEntity
//
//
//
//        //根据服务名获得服务清单
//        ServiceInstance serviceInstance = this.loadBalancerClient.choose("MICROSERVICE-PROVIDER");
//        String ip = serviceInstance.getHost();
//        int port = serviceInstance.getPort();
//        System.out.println(
//                "【*** 服务提供实例信息 ***】host = "+ ip
//                +",port = "+ port
//                +",serviceId = " +serviceInstance.getServiceId()
//        );
//
////      模拟 rest 风格   ，因为这是本地项目获取的ip会是主机名，所以无法读取，但是上线之后不会有这个问题
////      return restTemplate.exchange( "http://"+ip+":"+"port"+"/"+"book/"+id, HttpMethod.GET, new HttpEntity<>(  httpHeaders   ), Book.class ).getBody();
//
//
//        return restTemplate.exchange(  RESTURI+"book/"+id, HttpMethod.GET, new HttpEntity<>(  httpHeaders   ), Book.class ).getBody();
//
//    }
//
//    @GetMapping("/getAll")
//    public List<Book> getAll(){
//        //return  restTemplate.getForObject(URL+"get" +"All",List.class);
//        return restTemplate.exchange(RESTURI+"book/"+"getAll",HttpMethod.GET, new HttpEntity<Object>(  httpHeaders ), List.class).getBody();
//    }
//


    @GetMapping("{id}")
    public Object get(@PathVariable("id") Integer id) {
        return this.iProductClientService.get(id);
    }

    @GetMapping("/getAll")
    public Object list() {
        return this.iProductClientService.list();
    }


    @RequestMapping("/all/{id}")    //调用interface中接口方法
    public Object getBookAndUser( @PathVariable("id") long id){
        log.info("*******"+id);
        Map<String,Object> result = new HashMap<>();
        result.put("book",izuulClientService.getBook(id));
        log.info("******"+izuulClientService.getBook(id));
        result.put("user",izuulClientService.getUser(id+""));
        result.put("user2",izuulClientService.getUser2(id+""));
        result.put("productList",izuulClientService.getAll() );
        return  result;
    }

}
