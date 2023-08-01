/*
 *Copyright @2023 Grapefruit. All rights reserved.
 */
package com.grapefruit.springdataelasticsearch.service;

import com.grapefruit.springdataelasticsearch.model.Book;

import java.util.List;

/**
 * 功能
 *
 * @Author ZhangZhihuang
 * @Date 10/6/2023 3:08 pm
 * @Version 1.0
 */
public interface BookService {
    /**
     * 精确查询
     *
     * @param name name
     * @return page
     */
    List<Book> findByName(String name);

    /**
     * 全查询
     *
     * @return list
     */
    List<Book> findAll();

    /**
     * 使用baseMapper里的方法查
     *
     * @param name name
     * @return list
     */
    List<Book> findNameOrderById(String name);

    void batchsave(List<Book> list);
}
