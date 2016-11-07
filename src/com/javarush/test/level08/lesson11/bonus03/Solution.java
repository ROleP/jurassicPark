package com.javarush.test.level08.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/* Задача по алгоритмам
Задача: Введи с клавиатуры 20 слов и выведи их в алфавитном порядке.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] array = new String[20];
        for (int i = 0; i < array.length; i++)
        {
            array[i] = reader.readLine();
        }

        sort(array);

        for (String x : array)
        {
            System.out.println(x);
        }
    }

    public static void sort(String[] array)
    {
        //напишите тут ваш код

        //Simple integrated sort )))
        //Arrays.sort(array);

        //Common sort cycle
        for (int i = 0; i < array.length - 1; i++)
        {
            for (int j = 0; j < array.length - i - 1; j++)
            {
                if (isGreaterThan(array[j], array[j + 1]))
                {
                    String temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }

        }

        //Improved and optimized one - exits if the run was without changes
        /*
        for (int i = 0; ; i++) {
            boolean wasChanged = false;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (isGreaterThan(array[j], array[j + 1])) {
                    String temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    wasChanged = true;
                }
            }
            if (!wasChanged) break;
        }
        */
    }

    //Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b)
    {
        return a.compareTo(b) > 0;
    }
}
