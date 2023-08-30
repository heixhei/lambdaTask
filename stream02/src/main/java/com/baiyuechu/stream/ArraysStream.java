package com.baiyuechu.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 数组
 */
public class ArraysStream {
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 5, 6};
        //方法一
        Stream<Integer> stream = Arrays.stream(arr);
        //方法二
        Stream<Integer> stream2 = Stream.of(arr);
    }
}
