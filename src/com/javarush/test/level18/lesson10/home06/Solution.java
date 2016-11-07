package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(args[0]));
        ArrayList<Integer> chars = new ArrayList<Integer>(128);
        for (int i = 0; i < 128; i++)
        {
            chars.add(0);
        }
        while (bis.available() > 0)
        {
            int i = bis.read();
            //System.out.println(i);
            chars.set(i, chars.get(i)+1);
        }
        bis.close();
        for (int i = 0; i < chars.size(); i++)
        {
            if (chars.get(i) == 0) continue;
            System.out.println((char)i+" "+chars.get(i));
        }
    }
}
