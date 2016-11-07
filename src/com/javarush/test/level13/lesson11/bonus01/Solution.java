package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        ArrayList<Integer> list = new ArrayList<Integer>();
        LinkedList<Integer> result = new LinkedList<Integer>();

        /*
        FileInputStream input = new FileInputStream(fileName);
        BufferedReader fileRead = new BufferedReader(new InputStreamReader(input));

        while (true)
        {
            //int data = input.read();
            String s = fileRead.readLine();
            if (s.isEmpty()) break;
            int a;
            try
            {
                a = Integer.parseInt(s);
            } catch (NumberFormatException e) { continue; }
            if (a % 2 == 0) list.add(a);
        }
        fileRead.close();
        input.close();
        */

        Scanner sc = new Scanner(new File(fileName));

        while (sc.hasNextInt())
        {
            int a = sc.nextInt();
            list.add(a);
        }

        sc.close();

        outer:
        for (Integer i : list)
        {
            if (i % 2 == 0)
            {
                if (result.size() == 0)
                {
                    result.add(i);
                    continue;
                }
                for (Integer j : result)
                {
                    if (i < j)
                    {
                        result.add(result.indexOf(j), i);
                        continue outer;
                    }
                }
                result.add(i);
            }
        }

        for (Integer integer : result)
        {
            System.out.println(integer);
        }

    }
}
