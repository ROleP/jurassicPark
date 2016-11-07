package com.javarush.test.level15.lesson12.home01;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Разные методы для разных типов
1. Считать с консоли данные, пока не введено слово "exit".
2. Для каждого значения вызвать метод print. Если значение:
2.1. содержит точку '.', то вызвать метод print для Double;
2.2. больше нуля, но меньше 128, то вызвать метод print для short;
2.3. больше либо равно 128, то вызвать метод print для Integer;
2.4. иначе, вызвать метод print для String.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true)
        {
            String a = reader.readLine();
            if (a.equals("exit")) break;
            if (a.isEmpty()) continue;
            if (a.contains("."))
            {
                try
                {
                    Double d = Double.parseDouble(a);
                    print(d);
                    continue;
                }
                catch (NumberFormatException e)
                {
                    print(a);
                    continue;
                }
            }
            try
            {
                int i = Integer.parseInt(a);
                if (i > 0 && i < 128)
                {
                    print((short)i);
                }
                else if (i >= 128)
                {
                    print(i);
                } else print(a);
                continue;
            }
            catch (NumberFormatException e)
            {
                print (a);
                continue;
            }
        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
