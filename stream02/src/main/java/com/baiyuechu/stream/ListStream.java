package com.baiyuechu.stream;

import java.util.List;
import java.util.stream.Stream;

/**
 * 单列集合
 */
public class ListStream {
    public static void main(String[] args) {
        List<Author> authors = StreamDemo.getAuthors();
        Stream<Author> stream = authors.stream();
        System.out.println(stream);
    }
}
