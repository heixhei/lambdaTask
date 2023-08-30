package com.baiyuechu.functionalInterface;

import com.baiyuechu.stream.Author;
import com.baiyuechu.stream.StreamDemo;

import java.util.List;
import java.util.function.Predicate;

/**
 * and
 * 打印作家中年龄大于17并且姓名的长度大于1的作家。
 */
public class Functional_and {
    public static void main(String[] args) {
        List<Author> authors = StreamDemo.getAuthors();
        //lambda不支持and
        authors
                .stream()
                .filter(author -> author.getAge()>17&&author.getName().length()>1)
                .forEach(System.out::println);

        System.out.println("-----------------");
        //匿名内部类
        authors
                .stream()
                .filter(new Predicate<Author>() {
                    @Override
                    public boolean test(Author author) {
                        return author.getAge()>17;
                    }
                }.and(new Predicate<Author>() {
                    @Override
                    public boolean test(Author author) {
                        return author.getName().length()>1;
                    }
                }))
                .forEach(System.out::println);


    }
}
