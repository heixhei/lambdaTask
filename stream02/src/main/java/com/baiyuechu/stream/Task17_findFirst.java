package com.baiyuechu.stream;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * 获取流中的任意一个元素。该方法没有办法保证获取的一定是流中的第一个元素。
 *
 * 例子：
 *
 * 获取任意一个年龄大于18的作家，如果存在就输出他的名字
 */
public class Task17_findFirst {
    public static void main(String[] args) {
        List<Author> authors = StreamDemo.getAuthors();
        Optional<Author> first = authors
                .stream()
                .sorted((o1, o2) -> o1.getAge() - o2.getAge())
                .findFirst();
        System.out.println(first.get());
        Stream<Author> sorted = authors
                .stream()
                .sorted((o1, o2) -> o1.getAge() - o2.getAge());

    }

}
