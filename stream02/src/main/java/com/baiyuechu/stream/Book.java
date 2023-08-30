package com.baiyuechu.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Book {
    //id
    private Long id;
    //姓名
    private String name;
    //分类
    private String category;
    //评分
    private Integer score;
    //介绍
    private String intro;
}
