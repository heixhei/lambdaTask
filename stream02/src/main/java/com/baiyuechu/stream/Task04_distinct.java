package com.baiyuechu.stream;

import java.util.List;

/**
 * 打印所有作家的姓名，并且要求其中不能有重复元素。
 * 注意：distinct方法是依赖Object的equals方法来判断是否是相同对象的。所以需要注意重写equals方法。
 */
public class Task04_distinct {
    public static void main(String[] args) {
        List<Author> authors = StreamDemo.getAuthors();
        authors
                .stream()
                .distinct()
                .forEach(s -> System.out.println(s));
    }
}
