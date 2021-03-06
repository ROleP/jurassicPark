package com.javarush.test.level18.lesson03.task01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;

/* Максимальный байт
Ввести с консоли имя файла
Найти максимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        reader.close();
        int max = 0;
        FileInputStream fis = new FileInputStream(s);
        while (fis.available() > 0)
        {
            int i = fis.read();
            if (i > max) max = i;
        }
        fis.close();
        System.out.println(max);
    }
}
