/*
 *Copyright @2023 Grapefruit. All rights reserved.
 */
package com.grapefruit.springdataelasticsearch.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.grapefruit.springdataelasticsearch.mapper.BookMapper;
import com.grapefruit.springdataelasticsearch.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Books)表服务接口
 *
 * @author makejava
 * @since 2023-06-10 14:45:27
 */
@Service
@DS("mysql")
public class BooksMysqlService extends ServiceImpl<BookMapper, Book> implements IService<Book>, BookService {
    @Override
    public List<Book> findByName(String name) {
        return this.baseMapper.findByName(name);
    }

    @Override
    public List<Book> findAll() {
        return this.baseMapper.findAll();
    }

    @Override
    public List<Book> findNameOrderById(String name) {
        return this.baseMapper.findNameOrderById(name);
    }

    @Override
    public void batchsave(List<Book> list) {
    }
}
