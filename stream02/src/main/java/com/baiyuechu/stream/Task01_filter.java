package com.baiyuechu.stream;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 打印所有姓名长度大于1的作家的姓名
 */
public class Task01_filter {
    public static void main(String[] args) {
        List<Author> authors = StreamDemo.getAuthors();
        List<Author> collect = authors
                .stream()
                .distinct()
                .filter((Author author) -> {
                    return author.getName().length() > 1;
                }).collect(Collectors.toList());
        System.out.println(collect);
    }

}
