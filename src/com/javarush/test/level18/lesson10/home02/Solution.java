package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран частоту встречания пробела. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
4. Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String fileName = args[0];
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(fileName));
        int size = in.available();
        int spaces = 0;
        while (in.available()>0)
        {
            int i = in.read();
            if (i == 32) spaces++;
        }
        in.close();
        float spaceOccur = spaces*1.0f / size * 100;
        System.out.printf(Locale.ENGLISH, "%.2f",spaceOccur);
    }
}
