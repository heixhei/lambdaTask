package com.baiyuechu.functionalInterface;

import com.baiyuechu.stream.Author;
import com.baiyuechu.stream.StreamDemo;

import java.util.List;
import java.util.function.Predicate;

/**
 * negate
 * 打印作家中年龄不大于17的作家。
 */
public class Functional_negate {
    public static void main(String[] args) {
        List<Author> authors = StreamDemo.getAuthors();
        //lambda
        authors
                .stream()
                .filter(author -> !(author.getAge()>17))
                .forEach(System.out::println);

        System.out.println("---------");
        //匿名内部类
        authors
                .stream()
                .filter(new Predicate<Author>() {
                    @Override
                    public boolean test(Author author) {
                        return author.getAge()>17;
                    }
                }.negate())
                .forEach(System.out::println);
    }
}
