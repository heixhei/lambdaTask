package com.baiyuechu.stream;

import java.util.List;

/**
 * 可以用来判断是否都符合匹配条件，结果为boolean类型。如果都符合结果为true，否则结果为false。
 *
 * 例子：
 *
 * 判断是否所有的作家都是成年人
 */
public class Task15_noneMatch {
    public static void main(String[] args) {
        List<Author> authors = StreamDemo.getAuthors();
        boolean flag = authors
                .stream()
                .noneMatch(author -> author.getAge() > 100);
        System.out.println(flag);

    }
}
