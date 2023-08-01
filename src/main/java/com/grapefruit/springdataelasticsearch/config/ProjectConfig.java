package com.grapefruit.springdataelasticsearch.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * 自定义配置/解析
 *
 * @Author ZhangZhihuang
 * @Date 28/7/2023 11:07 pm
 * @Version 1.0
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "grape.es.project")
public class ProjectConfig {
    List<Project> list;

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class Project {
        /**
         * name
         */
        private String name;
        /**
         * type
         */
        private String type;

        @NestedConfigurationProperty
        /**
         * host
         */
        private Host host;


        @AllArgsConstructor
        @NoArgsConstructor
        @Data
        public static class Host {
            /**
             * ip地址
             */
            private String ip;
            /**
             * 端口
             */
            private int port;
        }
    }
}
