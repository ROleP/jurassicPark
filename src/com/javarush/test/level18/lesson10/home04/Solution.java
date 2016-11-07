package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
/*
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String a = reader.readLine();
        String b = reader.readLine();
        reader.close();
        RandomAccessFile fileOne = new RandomAccessFile(a, "r");
        RandomAccessFile fileTwo = new RandomAccessFile(b, "rw");
        byte[] fOne = new byte[(int)fileOne.length()];
        fileOne.readFully(fOne);
        fileOne.seek(0);
        while (true)
        {
            int i = fileTwo.read();
            if (i == -1) break;
            fileOne.write(i);
        }
        fileOne.write(fOne);
        fileOne.close();
        fileTwo.close();
    }
}
*/
public class Solution {
    public static void main(String[] args) throws Exception{

        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String File_name1 = r.readLine();
        String File_name2 = r.readLine();
        FileInputStream fr = new FileInputStream(File_name1);

        byte[] a = new byte[fr.available()];
        fr.read(a);
        FileInputStream fr2 = new FileInputStream(File_name2);
        byte[] b = new byte[fr2.available()];
        fr2.read(b);
        FileOutputStream wr = new FileOutputStream(File_name1);
        wr.write(b);
        wr = new FileOutputStream(File_name1, true);
        wr.write(a);

        r.close();
        fr.close();
        fr2.close();
        wr.close();
    }
}