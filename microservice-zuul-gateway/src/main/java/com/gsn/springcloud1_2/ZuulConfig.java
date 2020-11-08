package com.gsn.springcloud1_2;

import com.gsn.springcloud1_2.filter.AuthorizedRequestFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZuulConfig {
    @Bean
    public AuthorizedRequestFilter getAuthorizedRequestFilter(){
        return new AuthorizedRequestFilter();
    }
}
