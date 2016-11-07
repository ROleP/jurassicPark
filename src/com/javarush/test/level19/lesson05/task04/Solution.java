package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileOne = reader.readLine();
        String fileTwo = reader.readLine();
        reader.close();
        Scanner sc = new Scanner(new File(fileOne));
        sc.useDelimiter("\\.");
        if (!sc.hasNext())
        {
            sc.close();
            return;
        }
        FileWriter writer = new FileWriter(fileTwo);
        for ( ; ; )
        {
            writer.write(sc.next());
            if (sc.hasNext())
            {
                writer.write("!");
                continue;
            }
            else
            {
                sc.close();
                writer.close();
                break;
            }
        }
    }
}
