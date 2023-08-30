package com.baiyuechu.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode  // 去重
public class Author implements Comparable{
    //id
    private Long id;
    //姓名
    private String name;
    //年龄
    private Integer age;
    //介绍
    private String intro;
    //作品
    private List<Book> books;

    @Override
    public int compareTo(Object o) {
        return -1;
    }
}
