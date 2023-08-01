/*
 *Copyright @2022 Grapefruit. All rights reserved.
 */

package com.grapefruit.springdataelasticsearch;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.grapefruit.springdataelasticsearch.model.Book;
import com.grapefruit.springdataelasticsearch.repository.BookRepository;
import com.grapefruit.springdataelasticsearch.service.BooksCkService;
import com.grapefruit.springdataelasticsearch.service.BooksMysqlService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@Slf4j
@EnableTransactionManagement
public class SpringDataElasticsearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataElasticsearchApplication.class, args);
    }

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BooksCkService booksCkService;

    @Autowired
    private BooksMysqlService booksMysqlService;

    @Bean
    public CommandLineRunner elasticSearch() {
        return (args) -> {
            String time = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(LocalDateTime.now());
            // save data
            bookRepository.save(Book.builder().name("grape---" + time).price(10).build());

            // find data
            Page<Book> byName = bookRepository.findByName("zfdsfdsfsdohar", Pageable.unpaged());

            log.info(byName.toString());

            // fuzzy query
            Page<Book> byName2 = bookRepository.findByNameLike("%" + "zo" + "%", Pageable.unpaged());
            log.info(byName2.toString());
            System.out.println(byName2.toList());

            log.error("my manual error");
        };
    }

    @Bean
    public CommandLineRunner ck() {
        return (args) -> {
            // save data
            // booksCkService.save(Book.builder().name("ck-aaaa").build());

            List<Book> books = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                books.add(Book.builder().name("ck-aaaa" + 1).build());
            }
            booksCkService.batchsave(books);

            // find data
            List<Book> list = booksCkService.findByName("ck-aaaa");

            // query condition
            QueryWrapper<Book> qw = new QueryWrapper<>();
            qw.eq("name", "grape");

            // query
            List<Book> one = booksCkService.list(qw);

            System.out.println(list.toString());
        };
    }

    @Bean
    public CommandLineRunner mysql() {
        return (args) -> {
            // save data
            booksMysqlService.save(Book.builder().name("mysql-aaaa").build());

            // find data
            List<Book> list = booksMysqlService.findByName("mysql-aaaa");

            // query condition
            QueryWrapper<Book> qw = new QueryWrapper<>();
            qw.eq("name", "grape");

            // query
            List<Book> one = booksMysqlService.list(qw);

            System.out.println(list.toString());
        };
    }
}
