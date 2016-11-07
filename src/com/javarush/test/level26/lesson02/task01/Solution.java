package com.javarush.test.level26.lesson02.task01;

import java.util.Arrays;
import java.util.Comparator;

/* Почитать в инете про медиану выборки
Реализовать логику метода sort, который должен сортировать данные в массиве по удаленности от его медианы
Вернуть отсортированный массив от минимального расстояния до максимального
Если удаленность одинаковая у нескольких чисел, то выводить их в порядке возрастания
*/
public class Solution {
    public static Integer[] sort(Integer[] array) {
        //implement logic here
        Integer[] copy = array;
        Arrays.sort(copy);
        final double mediana;
        if (copy.length % 2 == 1)
            mediana = copy[copy.length/2];
        else
            mediana = (copy[copy.length/2] + copy[(copy.length/2)-1])/2.0;
        Comparator<Integer> medianaComaparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                double dist1 = Math.abs(o1 - mediana);
                double dist2 = Math.abs(o2 - mediana);
                if (dist1 == dist2)
                    return o1 - o2;
                return (int)(dist1*2) - (int)(dist2*2);
            }
        };
        Arrays.sort(copy, medianaComaparator);
        return copy;
    }
}
