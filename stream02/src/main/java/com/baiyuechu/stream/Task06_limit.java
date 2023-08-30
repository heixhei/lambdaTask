package com.baiyuechu.stream;

import java.util.List;
//对流中的元素按照年龄进行降序排序，并且要求不能有重复的元素,然后打印其中年龄最大的两个作家的姓名。
public class Task06_limit {
    public static void main(String[] args) {
        List<Author> authors = StreamDemo.getAuthors();
        authors
                .stream()
                .sorted()
                .limit(2)
                .forEach(s-> System.out.println(s));
    }
}
