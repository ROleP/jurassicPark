package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байт или байты с минимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        reader.close();
        List<Integer> bytes = new LinkedList<Integer>();
        List<Integer> occur = new LinkedList<Integer>();
        FileInputStream fis = new FileInputStream(s);
        while (fis.available() > 0)
        {
            int i = fis.read();
            int index = bytes.indexOf(i);
            if (index == -1)
            {
                bytes.add(i);
                occur.add(1);
                continue;
            }
            occur.set(index, occur.get(index)+1);
        }
        fis.close();
        for (int i = 0; i < occur.size() - 1; i++)
        {
            for (int j = 0; j < occur.size() - i - 1 ; j++)
            {
                if (occur.get(j) > occur.get(j+1))
                    mirrorSort(bytes, occur, j);
            }
        }
        for (int i = 0; i < 2; i++)
        {
            System.out.print(bytes.get(i)+" ");
        }
    }

    private static void mirrorSort(List<Integer> a, List<Integer> b, int index)
    {
        int aValue = a.remove(index);
        int bValue = b.remove(index);
        a.add(index+1, aValue);
        b.add(index+1, bValue);
    }
}
