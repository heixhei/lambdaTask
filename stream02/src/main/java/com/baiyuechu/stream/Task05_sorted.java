package com.baiyuechu.stream;

import java.util.Comparator;
import java.util.List;

/**
 * 对流中的元素按照年龄进行降序排序，并且要求不能有重复的元素。
 */
public class Task05_sorted {
    public static void main(String[] args) {
        List<Author> authors = StreamDemo.getAuthors();
        authors
                .stream()
                .sorted()//注意：如果调用空参的sorted()方法，需要流中的元素是实现了Comparable。
                .forEach(s-> System.out.println(s));
        authors
                .stream()
                .sorted(new Comparator<Author>() {
                    @Override
                    public int compare(Author o1, Author o2) {
                        return o2.getAge() - o1.getAge();//如果调用有参的sorted()方法，需要流中的元素是可以比较的东西。
                    }
                })
                .forEach(s -> System.out.println(s));
    }
}
