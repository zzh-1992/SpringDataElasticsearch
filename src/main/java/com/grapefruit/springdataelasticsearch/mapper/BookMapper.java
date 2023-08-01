/*
 *Copyright @2022 Grapefruit. All rights reserved.
 */

package com.grapefruit.springdataelasticsearch.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.grapefruit.springdataelasticsearch.model.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Collection;
import java.util.List;

@Mapper
public interface BookMapper extends BaseMapper<Book> {
    /**
     * 精确查询
     *
     * @param name name
     * @return page
     */
    @Select("select * from my_database.books where name = #{name}")
    List<Book> findByName(String name);

    /**
     * 全查询
     *
     * @return list
     */
    @Select("select * from my_database.books")
    List<Book> findAll();

    /**
     * 使用baseMapper里的方法查
     *
     * @param name name
     * @return list
     */
    List<Book> findNameOrderById(String name);


    /**
     * 批量插入
     *
     * @param entityList entityList
     * @return int
     */
    Integer insertBatchSomeColumn(Collection<Book> entityList);
}
