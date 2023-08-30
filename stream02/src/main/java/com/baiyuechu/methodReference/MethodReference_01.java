package com.baiyuechu.methodReference;

import com.baiyuechu.stream.Author;
import com.baiyuechu.stream.StreamDemo;

import java.util.List;
import java.util.stream.Stream;

/**
 * 引用类的静态方法
 * 类名::方法名
 *  如果我们在重写方法的时候，方法体中只有一行代码，并且这行代码是调用了某个类的静态方法，并且我们把要重写的抽象方法中所有的参数都按照顺序传入了这个静态方法中，这个时候我们就可以引用类的静态方法。
 */
public class MethodReference_01 {
    public static void main(String[] args) {
        List<Author> authors = StreamDemo.getAuthors();
        Stream<Author> stream = authors.stream();
        stream
                .map(author -> author.getAge())
                .map(age -> String.valueOf(age));
        stream
                .map(author -> author.getAge())
                .map(String::valueOf);



    }
}
