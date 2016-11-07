package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        int worlds = 0;
        Scanner sc = new Scanner(new File(fileName));
        sc.useDelimiter(Pattern.compile("[\\p{Punct}\\s]"));
        while (sc.hasNext())
        {
            String nex = sc.next();
            //System.out.println(nex);
            if (nex.equals("world")) worlds++;
        }
        sc.close();
        System.out.println(worlds);
    }
}
