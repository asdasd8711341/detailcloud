package com.gsn.springcloud1_2;

import com.gsn.springcloud1_2.filter.AuthorizedRequestFilter;
import org.jboss.logging.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZuulConfig {

    private static Logger logger = Logger.getLogger(AuthorizedRequestFilter.class);

    @Bean
    public AuthorizedRequestFilter getAuthorizedRequestFilter(){
        logger.debug("过滤器已启动");

        return new AuthorizedRequestFilter();
    }
}
