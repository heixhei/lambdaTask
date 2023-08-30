package com.baiyuechu.functionalInterface;

import com.baiyuechu.stream.Author;
import com.baiyuechu.stream.StreamDemo;

import java.util.List;
import java.util.function.Predicate;

/**
 * or
 * 打印作家中年龄大于17或者姓名的长度小于2的作家。
 */
public class Functional_or {
    public static void main(String[] args) {
        //lambda
        List<Author> authors = StreamDemo.getAuthors();
        authors
                .stream()
                .filter(author -> author.getAge()>17||author.getName().length()<2)
                .forEach(System.out::println);

        System.out.println("-----------");
        //匿名内部类
        authors
                .stream()
                .filter(new Predicate<Author>() {
                    @Override
                    public boolean test(Author author) {
                        return author.getAge()>17;
                    }
                }.or(new Predicate<Author>() {
                    @Override
                    public boolean test(Author author) {
                        return author.getName().length()<2;
                    }
                }))
                .forEach(System.out::println);

    }
}
