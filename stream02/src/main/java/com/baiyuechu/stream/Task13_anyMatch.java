package com.baiyuechu.stream;

import java.util.List;

/**
 * 可以用来判断是否有任意符合匹配条件的元素，结果为boolean类型。
 */
public class Task13_anyMatch {
    public static void main(String[] args) {
        List<Author> authors = StreamDemo.getAuthors();
        boolean flag = authors
                .stream()
                .anyMatch(author -> author.getAge() > 29);
        System.out.println(flag);
    }
}
