/*
 *Copyright @2022 Grapefruit. All rights reserved.
 */

package com.grapefruit.springdataelasticsearch.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * 功能
 *
 * @Author ZhangZhihuang
 * @Date 2022/12/15 19:52
 * @Version 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(indexName="books")
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
