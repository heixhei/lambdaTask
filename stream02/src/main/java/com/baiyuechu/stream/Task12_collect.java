package com.baiyuechu.stream;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 可以用来或者流中的最值。
 */
public class Task12_collect {
    public static void main(String[] args) {
        List<Author> authors = StreamDemo.getAuthors();
        //        获取一个存放所有作者名字的List集合。
        List<String> collect = authors
                .stream()
                .map(author -> author.getName())
                .collect(Collectors.toList());
        System.out.println(collect);
        //获取一个所有书名的Set集合。
        Set<Book> collect1 = authors
                .stream()
                .flatMap(author -> author.getBooks().stream())
                .distinct()
                .collect(Collectors.toSet());
        System.out.println(collect1);

        //获取一个Map集合，map的key为作者名，value为List
        Map<String, List<Book>> collect2 = authors
                .stream()
                .distinct()
                .collect(Collectors.toMap(author -> author.getName(), author -> author.getBooks()));
        System.out.println(collect2);
    }
}
