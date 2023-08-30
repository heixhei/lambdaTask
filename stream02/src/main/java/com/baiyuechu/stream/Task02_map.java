package com.baiyuechu.stream;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * 打印所有作家的姓名
 */
public class Task02_map {
    public static void main(String[] args) {
        List<Author> authors = StreamDemo.getAuthors();
        authors
                .stream()
                .map(new Function<Author, String>() {
                    @Override
                    public String apply(Author author) {
                        return author.getName();
                    }
                })
                .forEach(new Consumer<String>() {
                    @Override
                    public void accept(String s) {
                        System.out.println(s);
                    }
                });

    }
}
