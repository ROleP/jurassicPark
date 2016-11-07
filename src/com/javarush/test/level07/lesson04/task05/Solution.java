package com.javarush.test.level07.lesson04.task05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/* Один большой массив и два маленьких
1. Создать массив на 20 чисел.
2. Ввести в него значения с клавиатуры.
3. Создать два массива на 10 чисел каждый.
4. Скопировать большой массив в два маленьких: половину чисел в первый маленький, вторую половину во второй маленький.
5. Вывести второй маленький массив на экран, каждое значение выводить с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        int[] mass1 = new int[20];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < mass1.length; i++) mass1[i] = Integer.parseInt(reader.readLine());
        int[] mass2 = new int[10];
        int[] mass3 = new int[10];
        mass2 = Arrays.copyOfRange(mass1, 0, 10);
        mass3 = Arrays.copyOfRange(mass1, 10, 20);
        for (int i = 0; i < mass3.length; i++) System.out.println(mass3[i]);

    }
}
