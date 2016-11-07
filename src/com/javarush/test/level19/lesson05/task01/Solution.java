package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileInName = reader.readLine();
        String fileOutName = reader.readLine();
        reader.close();
        FileInputStream fis = new FileInputStream(fileInName);
        FileOutputStream fos = new FileOutputStream(fileOutName);
        while (fis.available()>1)
        {
            fis.read();
            fos.write(fis.read());
        }
        fis.close();
        fos.close();
    }
}
