package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileOne = reader.readLine();
        String fileTwo = reader.readLine();
        reader.close();
        Scanner sc = new Scanner(new File(fileOne));
        sc.useDelimiter(Pattern.compile("\\s"));
        FileWriter writer = new FileWriter(fileTwo);
        while (sc.hasNext())
        {
            if (sc.hasNextInt())
            {
                writer.write(sc.nextInt()+" ");
                continue;
            }
            //writer.write(" ");
            sc.next();
        }
        sc.close();
        writer.close();
    }
}
