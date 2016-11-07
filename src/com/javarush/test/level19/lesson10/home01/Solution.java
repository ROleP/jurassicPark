package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

import java.io.*;
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
                return ((Comparable)((Map.Entry)(obj1)).getKey()).compareTo(((Map.Entry)(obj2)).getKey());
            }
        });
        for (Object o : list)
        {
            System.out.println(((Map.Entry)(o)).getKey() + " " + ((Map.Entry)(o)).getValue());
        }
    }
}
