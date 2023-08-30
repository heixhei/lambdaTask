package com.baiyuechu.stream;

import java.util.List;

//打印除了年龄最大的作家外的其他作家，要求不能有重复元素，并且按照年龄降序排序。
public class Task07_skip {
    public static void main(String[] args) {
        List<Author> authors = StreamDemo.getAuthors();
        authors
                .stream()
                .sorted()
                .skip(1)
                .forEach(s -> System.out.println(s));
    }
}
