package com.javarush.test.level08.lesson11.home08;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Пять наибольших чисел
Создать массив на 20 чисел. Заполнить его числами с клавиатуры. Вывести пять наибольших чисел.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[20];
        for (int i = 0; i < array.length; i++)
        {
            array[i] = Integer.parseInt(reader.readLine());
        }

        sort(array);

        System.out.println(array[0]);
        System.out.println(array[1]);
        System.out.println(array[2]);
        System.out.println(array[3]);
        System.out.println(array[4]);
    }

    public static void sort(int[] array)
    {
        //напишите тут ваш код
        //Общее число проходов - длина массива-1, чтобы перевести число из одного края в другой
        for (int i = 0; i < array.length - 1; i++)
        {
            //Число сравнений в проходе - каждый раз на 1 меньше, т.к. в первом роходе минимальное число будет переставлено в конец (т.к. будет переставляться вперед в каждом сравнении), во второй - второе минимальное и т.д.
            for (int j = 0; j < array.length - i - 1; j++)
            {
                if (array[j] < array[j + 1])
                {
                    //Меняем соседние числа местами
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
