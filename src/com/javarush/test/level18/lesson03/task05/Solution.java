package com.javarush.test.level18.lesson03.task05;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;




/* Сортировка байт
Ввести с консоли имя файла
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран
Закрыть поток ввода-вывода

Пример байт входного файла
44 83 44

Пример вывода
44 83
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
                if (bytes.get(j) > bytes.get(j+1))
                    mirrorSort(bytes, occur, j);
            }
        }
        for (int i = 0; i < bytes.size(); i++)
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
