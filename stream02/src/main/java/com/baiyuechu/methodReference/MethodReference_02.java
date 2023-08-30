package com.baiyuechu.methodReference;

import com.baiyuechu.stream.Author;
import com.baiyuechu.stream.StreamDemo;

import java.util.List;
import java.util.stream.Stream;

/**
 * 引用对象的实例方法
 * 对象名::方法名
 *  如果我们在重写方法的时候，方法体中只有一行代码，并且这行代码是调用了某个对象的成员方法，并且我们把要重写的抽象方法中所有的参数都按照顺序传入了这个成员方法中，这个时候我们就可以引用对象的实例方法
 */
public class MethodReference_02 {
    public static void main(String[] args) {
        List<Author> authors = StreamDemo.getAuthors();
        Stream<Author> stream = authors.stream();
        StringBuilder sb = new StringBuilder();
        stream.map(author -> author.getName())
                .forEach(sb::append);

    }
}
