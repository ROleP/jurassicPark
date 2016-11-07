package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String a = reader.readLine();
        String b = reader.readLine();
        reader.close();
        FileInputStream fis = new FileInputStream(a);
        FileOutputStream fos = new FileOutputStream(b);
        byte[] buff = new byte[fis.available()];
        fis.read(buff);
        fis.close();
        for (int i = buff.length - 1; i >= 0 ; i--)
        {
            int j = buff[i];
            fos.write(j);
        }
        fos.close();
    }
}
