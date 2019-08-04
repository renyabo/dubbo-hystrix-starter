package com.tnp;

import com.tnp.util.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DubboHystrixAutoConfiguration {

    @Bean
    public BeanUtils applicationContextHolder() {
        return new BeanUtils();
    }

}
