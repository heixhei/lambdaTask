package com.baiyuechu.optional;

import com.baiyuechu.stream.Author;
import com.baiyuechu.stream.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class OptionalDemo {
    public static void main(String[] args) {

        Author author = getAuthor();
        //创建Optional对象-ofNullable
        Optional<Author> authorOptional= Optional.ofNullable(author);
        authorOptional.ifPresent(new Consumer<Author>() {
            @Override
            public void accept(Author author) {
                System.out.println(author);//安全消费值
            }
        });
        //确定一个对象不是空的则可以使用Optional的静态方法of来把数据封装成Optional对象
        Optional<Author> author1 = Optional.of(author);

        //安全获取值-orElseGet
        Author author2 = authorOptional.orElseGet(new Supplier<Author>() {
            @Override
            public Author get() {
                return new Author();
            }
        });
        System.out.println(author2);
        //安全获取值-orElseThrow
        Author author3 = null;
        try {
            author3 = authorOptional.orElseThrow(new Supplier<Throwable>() {
                @Override
                public Throwable get() {
                    return new RuntimeException("author为空");
                }
            });
            System.out.println(author3);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }

        //过滤
        authorOptional.filter(author4->author.getAge()>100).ifPresent(author5 -> System.out.println(author5) );

        //判断
        if (authorOptional.isPresent()) {
            System.out.println(authorOptional.get().getName());
        }

        //数据转换
        authorOptional.map(author4 -> author4.getBooks()).ifPresent(books -> System.out.println(books));



    }

    public static Author getAuthor() {
        Author author = new Author(1L, "蒙多", 17, "一个祖安人", null);
        List<Book> book1 = new ArrayList<>();
        book1.add(new Book(1L, "*", "哲学,爱情", 80, "*"));
        author.setBooks(book1);
        return author;
    }
}
