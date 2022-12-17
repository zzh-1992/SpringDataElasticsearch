/*
 *Copyright @2022 Grapefruit. All rights reserved.
 */

package com.grapefruit.springdataelasticsearch;

import com.grapefruit.springdataelasticsearch.model.Book;
import com.grapefruit.springdataelasticsearch.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@SpringBootApplication
public class SpringDataElasticsearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataElasticsearchApplication.class, args);
    }

    @Autowired
    BookRepository bookRepository;

    Logger logger = LoggerFactory.getLogger(SpringDataElasticsearchApplication.class);

    @Bean
    public CommandLineRunner commandLineRunner() {
        return (args) -> {
            // save data
            bookRepository.save(Book.builder().name("aaaa").price(10).build());

            // find data
            Page<Book> byName = bookRepository.findByName("zfdsfdsfsdohar", Pageable.unpaged());

            logger.info(byName.toString());

            // fuzzy query
            Page<Book> byName2 = bookRepository.findByNameLike("%" + "zo" + "%", Pageable.unpaged());
            logger.info(byName2.toString());
            System.out.println(byName2.toList());

            logger.error("my manual error");
        };
    }
}
