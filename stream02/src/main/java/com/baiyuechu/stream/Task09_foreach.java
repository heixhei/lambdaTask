package com.baiyuechu.stream;

import java.util.List;

/**
 * 输出所有作家名字
 */
public class Task09_foreach {
    public static void main(String[] args) {
        List<Author> authors = StreamDemo.getAuthors();
        authors
                .stream()
                .map(author -> {
                    return author.getName();
                })
                .forEach(System.out::println);
    }
}
