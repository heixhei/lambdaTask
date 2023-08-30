package com.baiyuechu.stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * map只能把一个对象转换成另一个对象来作为流中的元素。而flatMap可以把一个对象转换成多个对象作为流中的元素。
 */
public class Task08_flatMap {
    public static void main(String[] args) {
        List<Author> authors = StreamDemo.getAuthors();
//        打印所有书籍的名字。要求对重复的元素进行去重。
        authors
                .stream()
                .flatMap(new Function<Author, Stream<?>>() {
                    @Override
                    public Stream<?> apply(Author author) {
                        return author.getBooks().stream();
                    }
                })
                .distinct()
                .forEach(s -> System.out.println(s));
// 打印现有数据的所有分类。要求对分类进行去重。不能出现这种格式：哲学,爱情     爱情
        authors
                .stream()
                .flatMap(new Function<Author, Stream<Book>>() {
                    @Override
                    public Stream<Book> apply(Author author) {
                        return author.getBooks().stream();
                    }
                })
                .distinct()
                .flatMap(new Function<Book, Stream<?>>() {
                    @Override
                    public Stream<?> apply(Book book) {
                        return Arrays.stream(book.getCategory().split(","));
                    }
                })
                .distinct()
                .forEach(s-> System.out.println(s));

        authors
                .stream()
                .flatMap((Author author)->{
                    return author.getBooks().stream();
                })
                .distinct()
                .flatMap((Book book)->{
                    return Arrays.stream(book.getCategory().split(","));
                })
                .distinct()
                .forEach(s-> System.out.println(s));

        System.out.println("-----------");
        authors
                .stream()
                .flatMap((Author author)->{
                    return author.getBooks().stream();
                })
                .forEach(book -> System.out.println(book));
    }
}
