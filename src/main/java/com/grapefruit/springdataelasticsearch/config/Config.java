package com.grapefruit.springdataelasticsearch.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 功能
 *
 * @Author ZhangZhihuang
 * @Date 1/8/2023 10:08 pm
 * @Version 1.0
 */
@Configuration
public class Config {
    @Bean
    public EasySqlInjector easySqlInjector() {
        return new EasySqlInjector();
    }
}
