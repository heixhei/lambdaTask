package com.baiyuechu;

import java.util.function.Function;

/**
 * lambda练习4-泛型的使用
 */
public class Task4 {
    public static void main(String[] args) {
        Integer result1 = typeConverter(s1 -> {
            return Integer.valueOf(s1);
        });
        System.out.println(result1);


        Integer result2 = typeConverter((String s) -> {
            return Integer.valueOf(s);
        });
        System.out.println(result2);

    }

    public static <R> R typeConverter(Function<String, R> function) {
        String str = "1235";
        R result = function.apply(str);
        return result;
    }
}
