package com.baiyuechu.stream;

import java.util.List;
import java.util.function.Function;

/**
 * 打印所有作家的年龄并+10
 */
public class Task03_map {
    public static void main(String[] args) {
        List<Author> authors = StreamDemo.getAuthors();
        authors
                .stream()
                .map(new Function<Author, Integer>() {

                    @Override
                    public Integer apply(Author author) {
                        return author.getAge();
                    }
                })
                .map(new Function<Integer, Integer>() {
                    @Override
                    public Integer apply(Integer age) {
                        return age + 10;
                    }
                })
                .forEach(s-> System.out.println(s));
    }
}
