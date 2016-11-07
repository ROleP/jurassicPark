package com.javarush.test.level07.lesson04.task04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/* Массив из чисел в обратном порядке
1. Создать массив на 10 чисел.
2. Ввести с клавиатуры 10 чисел и записать их в массив.
3. Расположить элементы массива в обратном порядке.
4. Вывести результат на экран, каждое значение выводить с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        int[] iMass = new int[10];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) iMass[i] = Integer.parseInt(reader.readLine());
        for (int i = 0; i < iMass.length / 2; i++)
        {
            int tmp = iMass[i];
            iMass[i] = iMass[iMass.length - i - 1];
            iMass[iMass.length - i - 1] = tmp;
        }

        for (int i = 0; i < iMass.length; i++) System.out.println(iMass[i]);

    }
}
