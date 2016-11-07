package com.javarush.test.level06.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Задача по алгоритмам
Задача: Написать программу, которая вводит с клавиатуры 5 чисел и выводит их в возрастающем порядке.
Пример ввода:
3
2
15
6
17
Пример вывода:
2
3
6
15
17
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //напишите тут ваш код
        ArrayList<Integer> incoming = new ArrayList<Integer>();
        //ArrayList<Integer> outgoing = new ArrayList<Integer>();

        for (int i = 0; i < 5; i++)
        {
            incoming.add(Integer.parseInt(reader.readLine()));
        }

        int tmp;


        for (int i = incoming.size() - 1; i > 0; i--)
        {
            for (int j = 0; j < i; j++)
            {
                if (incoming.get(j) > incoming.get(j + 1))
                {
                    tmp = incoming.get(j);
                    incoming.set(j, incoming.get(j + 1));
                    incoming.set(j + 1, tmp);
                }
            }

        }

        for (int i = 0; i < incoming.size(); i++)
        {
            System.out.println(incoming.get(i));
        }


    }
}
