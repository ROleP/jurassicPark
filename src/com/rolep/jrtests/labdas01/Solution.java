package com.rolep.jrtests.labdas01;

import java.util.function.Consumer;

/**
 * Created by rolep on 24/09/16.
 */

public class Solution {
;
    public static void main(String[] args) {
        execute(() -> System.out.println("Inside"));
        consume(System.out::println, "Test");
    }

    public static void  execute(Runnable runnable) {
        System.out.println("Start");
        runnable.run();
        System.out.println("Stop");
    }

    public static void consume(Consumer<String> consumer, String out) {
        System.out.println("Start consume");
        consumer.accept(out);
        System.out.println("Stop consume");
    }
}
