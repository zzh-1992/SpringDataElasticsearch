/*
 *Copyright @2022 Grapefruit. All rights reserved.
 */

package com.grapefruit.springdataelasticsearch.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * 实体-book
 *
 * @Author ZhangZhihuang
 * @Date 2022/12/15 19:52
 * @Version 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
// @Document->用于spring.data.elasticsearch标注实体类与索引(索引类似关系型数据库中的表)
@Document(indexName="books")

// @TableName ->mybatisplus用于映射实体类于数据库中的表
@TableName("books")
@Data
public class Book {
    @Id
    private String id;

    @Field(type = FieldType.Text)
    private String name;

    @Field(type = FieldType.Text)
    private String summary;

    @Field(type = FieldType.Integer)
    private Integer price;
}
