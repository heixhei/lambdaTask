package com.baiyuechu;

import java.util.function.IntBinaryOperator;

/**
 * lambda练习2
 */
public class Task2 {
    public static void main(String[] args) {
        int result1 = calculateNum(new IntBinaryOperator() {
            @Override
            public int applyAsInt(int left, int right) {
                return left + right;
            }
        });

        int result2 = calculateNum((int left, int right) -> {
            return left + right;
        });

        System.out.println(result1);
        System.out.println(result2);
    }

    public static int calculateNum(IntBinaryOperator operator) {
        int a = 10;
        int b = 20;
        return operator.applyAsInt(a, b);
    }
}
