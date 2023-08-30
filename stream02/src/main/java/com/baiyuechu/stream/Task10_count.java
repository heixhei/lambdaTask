package com.baiyuechu.stream;

import java.util.List;

/**
 * 可以用来获取当前流中元素的个数。
 */
public class Task10_count {
    public static void main(String[] args) {
        List<Author> authors = StreamDemo.getAuthors();
        long count = authors
                .stream()
                .flatMap(author -> author.getBooks().stream())
                .distinct()
                .count();
        System.out.println(count);


    }
}
