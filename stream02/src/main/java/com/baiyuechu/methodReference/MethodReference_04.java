package com.baiyuechu.methodReference;

import com.baiyuechu.stream.Author;
import com.baiyuechu.stream.StreamDemo;

import java.util.List;

/**
 * 构造器引用
 * 类名::new
 *  如果我们在重写方法的时候，方法体中只有一行代码，并且这行代码是调用了某个类的构造方法，并且我们把要重写的抽象方法中的所有的参数都按照顺序传入了这个构造方法中，这个时候我们就可以引用构造器。
 */
public class MethodReference_04 {

    public static void main(String[] args) {
        List<Author> authors = StreamDemo.getAuthors();
        authors.stream()
                .map(author -> author.getName())
                .map(StringBuilder::new)
                .map(sb->sb.append("-白月初").toString())
                .forEach(str-> System.out.println(str));

    }
}
