package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException, FileNotFoundException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String one = reader.readLine();
        String two = reader.readLine();
        String three = reader.readLine();
        reader.close();
        BufferedOutputStream outOne = new BufferedOutputStream(new FileOutputStream(one));
        BufferedInputStream inTwo = new BufferedInputStream(new FileInputStream(two));
        BufferedInputStream inThree = new BufferedInputStream(new FileInputStream(three));
        while (inTwo.available()>0)
        {
            outOne.write(inTwo.read());
        }
        inTwo.close();
        while (inThree.available()>0)
        {
            outOne.write(inThree.read());
        }
        inThree.close();
        outOne.close();
    }
}
