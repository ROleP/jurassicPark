package com.javarush.test.level05.lesson12.bonus03;

import java.io.*;

/* Задача по алгоритмам
Написать программу, которая:
1. вводит с консоли число N > 0
2. потом вводит N чисел с консоли
3. выводит на экран максимальное из введенных N чисел.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //напишите тут ваш код
        /// Мой рабочий вариант с проверками и обработкой исключений!!!
        int maximum = 0;
        int sizert = 0;
        int i = 0;

        while (true)
        {
            try
            {

                if (sizert == 0)
                {
                    sizert = Integer.parseInt(reader.readLine());
                    if (sizert <= 0) sizert = 0;
                    continue;
                }

                for (; i < sizert; i++)
                {
                    int number = Integer.parseInt(reader.readLine());
                    if (number > maximum) maximum = number;
                }
                System.out.println(maximum);
                break;
            }
            catch (NumberFormatException e)
            {
                System.out.println("Not a valid number!!!!!");
                continue;
            }
        }

        /*  ТИПА-РАБОЧИЙ ВАРИАНТ - который апрувится, но без проверок и т.п.

        int n = Integer.parseInt(reader.readLine()); //считываем n
        int maximum = 0; //инициализируем число maximum

        for (int i = 0; i<n; i++){ //входим в цикл по числу n

            //считываем число с консоли
            int temp = Integer.parseInt(reader.readLine());

            //если это нулевой цикл, то присваиваем числу
            //maximum значение считанного числа
            if (i==0) maximum=temp;

                //в дальнейшем значение присваиваем только если
                //число с консоли больше maximum
            else if (temp>maximum) maximum=temp;
        }

        System.out.println(maximum);
        */
    }
}
