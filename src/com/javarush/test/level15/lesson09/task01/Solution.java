package com.javarush.test.level15.lesson09.task01;

import java.util.HashMap;
import java.util.Map;

/* Статики 1
В статическом блоке инициализировать labels 5 различными парами.
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static
    {
        labels.put(23d, "asd");
        labels.put(12323d, "asd");
        labels.put(2322d, "asd");
        labels.put(23455d, "asd");
        labels.put(2365d, "asd");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
