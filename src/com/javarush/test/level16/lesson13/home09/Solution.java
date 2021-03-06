package com.javarush.test.level16.lesson13.home09;

/* Только по-очереди!
1. В классе Solution создать нить public static Read3Strings унаследовавшись от Thread.
2. В методе run реализовать чтение с консоли трех строк.
3. Три подряд введенных строки должны считываться в одной нити и объединяться в одну строку через пробел.
4. В методе main вывести результат для каждой нити.
5. Используйте join

Пример:
Входные данные
a
b
c
d
e
f
Выходные данные:
a b c
d e f
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static volatile BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws InterruptedException {
        Read3Strings t1 = new Read3Strings();
        Read3Strings t2 = new Read3Strings();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(t1.result/*print t1 result here*/);
        System.out.println(t2.result/*print t2 result here*/);
    }

    public static class Read3Strings extends Thread
    {
        public StringBuilder result = new StringBuilder();
        public void run()
        {
            int i = 0;
            try
            {
                while (true)
                {
                    i++;
                    result.append(reader.readLine());
                    if (i > 2) break;
                    result.append(" ");
                }
            } catch (IOException e) {}
        }
    }
}
