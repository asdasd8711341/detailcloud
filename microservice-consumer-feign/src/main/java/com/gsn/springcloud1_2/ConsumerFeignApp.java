package com.gsn.springcloud1_2;

import com.gsn.springcloud1_2.robinConfiguration.RobinConfigure;
import feign.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

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
@EnableFeignClients("com.gsn.springcloud1_2.service")  //注意:这里的值要填服务接口所在的包名
//启用feign客户端，告诉feign 操作接口的路径下的接口
public class ConsumerFeignApp {
    public static void main(String[] args) {


        SpringApplication.run(ConsumerFeignApp.class,args);
    }
}


