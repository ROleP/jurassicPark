package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
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
        String c = reader.readLine();
        reader.close();
        FileInputStream fis = new FileInputStream(a);
        int halfsize = fis.available() % 2 == 0 ? fis.available() / 2 : fis.available() / 2 + 1;
        FileOutputStream outOne = new FileOutputStream(b);
        FileOutputStream outTwo = new FileOutputStream(c);
        byte[] buff = new byte[halfsize];
        fis.read(buff);
        outOne.write(buff);
        while (fis.available() > 0)
        {
            int i = fis.read();
            outTwo.write(i);
        }
        fis.close();
        outOne.close();
        outTwo.close();
    }
}
