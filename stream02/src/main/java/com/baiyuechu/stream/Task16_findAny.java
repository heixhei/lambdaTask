package com.baiyuechu.stream;

import java.util.List;
import java.util.Optional;

/**
 * 获取流中的任意一个元素。该方法没有办法保证获取的一定是流中的第一个元素。
 *
 * 例子：
 *
 * 获取任意一个年龄大于18的作家，如果存在就输出他的名字
 */
public class Task16_findAny {
    public static void main(String[] args) {
        List<Author> authors = StreamDemo.getAuthors();
        Optional<Author> authorOptional = authors
                .stream()
                .filter(author -> author.getAge() > 18)
                .findAny();
        Author author = authorOptional.get();
        System.out.println(author);
    }
}
