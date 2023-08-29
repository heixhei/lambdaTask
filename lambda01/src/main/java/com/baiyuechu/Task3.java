package com.baiyuechu;

import java.util.function.IntPredicate;

/**
 * lambda练习3
 */
public class Task3 {
    public static void main(String[] args) {
        new Thread(()->{
            printNum(new IntPredicate() {
                @Override
                public boolean test(int value) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return value%2==0;
                }
            });
        }).start();

        new Thread(()->{
            printNum(( int values)->{
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                return values % 2 == 0;
            });
        }).start();


    }

    public static void printNum(IntPredicate predicate) {
        int[] arrs = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i:
             arrs) {
            if (predicate.test(i)) {
                System.out.println(i);
            }
        }
    }


}
