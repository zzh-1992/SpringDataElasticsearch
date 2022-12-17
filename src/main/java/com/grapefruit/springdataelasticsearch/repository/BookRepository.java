/*
 *Copyright @2022 Grapefruit. All rights reserved.
 */

package com.grapefruit.springdataelasticsearch.repository;

import com.grapefruit.springdataelasticsearch.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface BookRepository extends ElasticsearchRepository<Book, String> {
    /**
     * 精确查询
     *
     * @param name     name
     * @param pageable 分页
     * @return page
     */
    Page<Book> findByName(String name, Pageable pageable);

    /**
     * 模糊查询
     *
     * @param name     name
     * @param pageable 分页
     * @return page
     */
    Page<Book> findByNameLike(String name, Pageable pageable);
}