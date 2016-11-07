package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String fileName = args[0];
        int leterCount = 0;
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(fileName));
        while (in.available() > 0)
        {
            int i = in.read();
            if ( i>64 && i<91 || i>96 && i<123 ) leterCount++;
        }
        in.close();
        System.out.println(leterCount);
    }
}
