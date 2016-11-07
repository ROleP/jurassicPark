package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File(args[0]));
        sc.useDelimiter(Pattern.compile("[\\s]"));
        FileWriter writer = new FileWriter(args[1]);
        String s;
        boolean start = false;
        while (sc.hasNext())
        {
            s = sc.next();
            if (s.length()>6)
            {
                if (start) writer.write(",");
                writer.write(s);
                start = true;
            }
        }
        sc.close();
        writer.close();
    }
}
