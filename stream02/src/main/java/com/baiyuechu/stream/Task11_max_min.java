package com.baiyuechu.stream;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * 可以用来或者流中的最值。
 */
public class Task11_max_min {
    public static void main(String[] args) {
        List<Author> authors = StreamDemo.getAuthors();
        Optional<Integer> max = authors
                .stream()
                .flatMap(author -> author.getBooks().stream())
                .distinct()
                .map(book -> book.getScore())
                .max(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o1 - o2;
                    }
                });
        System.out.println(max.get());

        Optional<Integer> min = authors
                .stream()
                .flatMap(author -> author.getBooks().stream())
                .distinct()
                .map(book -> book.getScore())
                .min((Integer o1, Integer o2) -> o1 - o2);
        System.out.println(min.get());
    }
}
