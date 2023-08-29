package com.baiyuechu;

/**
 * lambda练习1-多线程lambda写法
 */
public class Task1 {
    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("很好");
            }
        }).start();

        new Thread(()->{
            System.out.println("nihao");
        }).start();

    }
}
