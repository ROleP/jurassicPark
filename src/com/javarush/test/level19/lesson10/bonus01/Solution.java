package com.javarush.test.level19.lesson10.bonus01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
оригинальный   редактированный    общий
file1:         file2:             результат:(lines)

строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка4                           REMOVED строка4
строка5        строка5            SAME строка5
строка0                           ADDED строка0
строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка5                           ADDED строка5
строка4        строка4            SAME строка4
строка5                           REMOVED строка5
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();

        BufferedReader fileOneReader = new BufferedReader(new FileReader(file1));
        BufferedReader fileTwoReader = new BufferedReader(new FileReader(file2));

        String one = null;
        String two = null;
        String onePrev = null;
        String twoPrev = null;

        while(true)
        {
            if (fileOneReader.ready() && one == null)
                one = fileOneReader.readLine();
            if (fileTwoReader.ready() && two == null)
                two = fileTwoReader.readLine();

            if (twoPrev != null && twoPrev.equals(one))
            {
                lines.add(new LineItem(Type.REMOVED, onePrev));
                lines.add(new LineItem(Type.SAME, twoPrev));
                one = null;
                onePrev = null;
                twoPrev = null;
                continue;
            }

            if (onePrev != null && onePrev.equals(two))
            {
                lines.add(new LineItem(Type.ADDED, twoPrev));
                lines.add(new LineItem(Type.SAME, onePrev));
                two = null;
                onePrev = null;
                twoPrev = null;
                continue;
            }

            if (one == null)
            {
                if (two == null)
                    break;
                else
                {
                    lines.add(new LineItem(Type.ADDED, two));
                    two = null;
                    continue;
                }
            }
            else if (two == null)
            {
                lines.add(new LineItem(Type.REMOVED, one));
                one = null;
                continue;
            }

            if (one.equals(two))
            {
                lines.add(new LineItem(Type.SAME, one));
                one = null;
                onePrev = null;
                two = null;
                twoPrev = null;
            }
            else
            {
                onePrev = one;
                one = null;
                twoPrev = two;
                two = null;
            }
        }

        fileOneReader.close();
        fileTwoReader.close();

        for (LineItem line : lines)
        {
            System.out.println(line.type + " " + line.line);
        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
