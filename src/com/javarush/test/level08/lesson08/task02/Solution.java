package com.javarush.test.level08.lesson08.task02;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* Удалить все числа больше 10
Создать множество чисел(Set<Integer>), занести туда 20 различных чисел.
Удалить из множества все числа больше 10.
*/

public class Solution
{
    public static HashSet<Integer> createSet()
    {
        //напишите тут ваш код
        Set<Integer> set = new HashSet<Integer>();
        Collections.addAll(set, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);
        return (HashSet) set;

    }

    public static HashSet<Integer> removeAllNumbersMoreThan10(HashSet<Integer> set)
    {
        //напишите тут ваш код
        /*
        for (Integer i : set) {
            System.out.println(i);
            if (i > 10) iterator.remove();
        }
        */
        //for (Integer j : set) System.out.println(j);
        Iterator<Integer> iter = set.iterator();
        while (iter.hasNext())
        {
            int i = iter.next();
            if (i > 10) iter.remove();
        }
        return set;
    }

    public static void main(String[] args)
    {


        HashSet<Integer> set = removeAllNumbersMoreThan10(createSet());
    }
}
