package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Map<String, Double> data = new HashMap<>();
        BufferedReader reader  = new BufferedReader(new FileReader(new File(args[0])));
        String s;
        double d;
        while ((s=reader.readLine())!=null)
        {
            d = 0d;
            String[] parsed = s.split(" ");
            if (data.containsKey(parsed[0])) d = data.get(parsed[0]);
            data.put(parsed[0],Double.parseDouble(parsed[1])+d);
        }
        reader.close();
        List list = new ArrayList(data.entrySet());
        Collections.sort(list, new Comparator()
        {
            public int compare(Object obj1, Object obj2)
            {
                return ((Comparable) ((Map.Entry) (obj2)).getValue()).compareTo(((Map.Entry) (obj1)).getValue());
            }
        });
        for (int i = 0; i < 1; i++)
        {
            String name = (String)((Map.Entry)(list.get(i))).getKey();
            System.out.println(name);
        }
        /*
        for (Object o : list)
        {
            System.out.println(((Map.Entry)(o)).getKey() + " " + ((Map.Entry)(o)).getValue());
        }
        */
    }
}
