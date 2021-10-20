package com.simonzhang.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VendorConfig {
    @Bean
    public Vendor getInstance() {
        return new Vendor();
    }
}
