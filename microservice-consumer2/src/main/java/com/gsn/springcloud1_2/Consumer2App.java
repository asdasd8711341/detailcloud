package com.gsn.springcloud1_2;

import com.gsn.springcloud1_2.robinConfiguration.RobinConfigure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableEurekaClient  //启用eureka客户端，这样能完成服务发现



//指定这个新的负载算法给 MICROSERVICE-PROVIDER 这个服务器用
//这里的name指服务的名称，如果需要有多个服务提供方，这个时候可以使用  @@RibbonClients 进行配置
//只对服务名为 MICROSERVICE-PROVIDER 下的服务清单采用 RobinConfigure 指定的 随机负载均衡方式
@RibbonClient(name = "MICROSERVICE-PROVIDER", configuration = RobinConfigure.class)
//@RibbonClients(value = {                  //多个服务器采用不同的策略的写法
//        @RibbonClient(name = "MICROSERVICE-PROVIDER", configuration = RobinConfigure.class),
//        @RibbonClient(name = "MICROSERVICE-PROVIDER-b", configuration = RobinConfigure.class)
//})
public class Consumer2App {
    public static void main(String[] args) {
        SpringApplication.run(Consumer2App.class,args);
    }
}
