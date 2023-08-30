package com.baiyuechu.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * 使用stream流（匿名内部类和lambda）
 */
public class StreamDemo {
    public static void main(String[] args) {
        List<Author> authors = getAuthors();
//        System.out.println(authors);
        //打印所有年龄小于18的作家的名字，并且要注意去重
        //匿名内部类
        authors.
                stream()//把集合转换成流
                .distinct()//先去除重复的作家
                .filter(new Predicate<Author>() {
                    @Override
                    public boolean test(Author author) {
                        return author.getAge() < 18;//筛选年龄小于18的
                    }
                })
                .forEach(new Consumer<Author>() {
                    @Override
                    public void accept(Author author) {
                        System.out.println(author.getName());//遍历打印名字
                    }
                });

        //lambda
        authors
                .stream()//转换成流
                .filter((Author author) -> {
                    return author.getAge() < 18;
                })
                .forEach((Author author) -> {
                    System.out.println(author.getName());//遍历打印名字
                });

    }

    public static List<Author> getAuthors() {
        Author author = new Author(1L, "蒙多", 17, "一个祖安人", null);
        Author author2 = new Author(2L, "亚拉索", 18, "艾欧尼亚", null);
        Author author3 = new Author(3L, "易大师", 19, "黑色玫瑰", null);
        Author author4 = new Author(3L, "易小师", 19, "黑色玫瑰", null);

        List<Book> book1 = new ArrayList<>();
        List<Book> book2 = new ArrayList<>();
        List<Book> book3 = new ArrayList<>();
        List<Book> book4 = new ArrayList<>();

        book1.add(new Book(1L, "*", "哲学,爱情", 80, "*"));
        book1.add(new Book(2L, "**", "爱情,个人成长", 80, "**"));

        book2.add(new Book(3L, "***", "爱情,传记", 70, "***"));
        book2.add(new Book(3L, "****", "个人成长,传记", 70, "****"));
        book2.add(new Book(4L, "*****", "哲学", 70, "*****"));

        book3.add(new Book(5L, "******", "个人成长", 60, "******"));
        book3.add(new Book(6L, "*******", "传记", 60, "*******"));
        book3.add(new Book(6L, "********", "爱情", 60, "********"));

        book4.add(new Book(5L, "******", "个人成长", 60, "******"));
        book4.add(new Book(6L, "*******", "个人成长,传记,爱情", 60, "*******"));
        book4.add(new Book(6L, "********", "哲学,爱情,个人成长", 60, "********"));


        author.setBooks(book1);
        author2.setBooks(book2);
        author3.setBooks(book3);
        author4.setBooks(book4);

        List<Author> authors = new ArrayList<>(Arrays.asList(author, author2, author3, author4));
        return authors;
    }
}
