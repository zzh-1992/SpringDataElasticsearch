/*
 *Copyright @2022 Grapefruit. All rights reserved.
 */

package com.grapefruit.springdataelasticsearch;

import com.grapefruit.springdataelasticsearch.model.Book;
import com.grapefruit.springdataelasticsearch.repository.BookRepository;
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

    @Bean
    public CommandLineRunner commandLineRunner() {
        return (args) -> {
            // save data
            bookRepository.save(Book.builder().id("1").name("zo22har").price(10).build());

            // find data
            Page<Book> byName = bookRepository.findByName("zohar", Pageable.unpaged());

            // fuzzy query
            Page<Book> byName2 = bookRepository.findByNameLike("%" + "zo" + "%", Pageable.unpaged());
            System.out.println(byName2.toList());
        };
    }
}
