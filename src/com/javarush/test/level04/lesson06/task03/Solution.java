package com.javarush.test.level04.lesson06.task03;

/* Сортировка трех чисел
Ввести с клавиатуры три числа, и вывести их в порядке убывания.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int s1 = Integer.parseInt(reader.readLine());
        int s2 = Integer.parseInt(reader.readLine());
        int s3 = Integer.parseInt(reader.readLine());
        int min = s1;
        int avg;
        int max;
        if (s2 < min)
        {
            min = s2;
            avg = s1;
            if (s3 < min)
            {
                min = s3;
                avg = s2;
                max = s1;
            }
            else
            {
                if (s3 < avg)
                {
                    avg = s3;
                    max = s1;
                }
                else max = s3;
            }
        }
        else
        {
            avg = s2;
            if (s3 < min)
            {
                min = s3;
                avg = s1;
                max = s2;
            }
            else
            {
                if (s3 < avg)
                {
                    avg = s3;
                    max = s2;
                }
                else max = s3;
            }
        }
        System.out.println(max);
        System.out.println(avg);
        System.out.println(min);
    }
}
