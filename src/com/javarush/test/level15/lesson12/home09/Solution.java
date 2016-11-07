package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException{
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        String[] parameters;
        ArrayList<String> alerts = new ArrayList<String>();
        parameters = s.substring(s.indexOf("?")+1).split("\\&");
        for (String parameter : parameters)
        {
            if (parameter.contains("="))
            {
                String[] parse = parameter.split("=");
                String a = parse[0];
                String b = parse[1];
                if ("obj".equals(a)) alerts.add(b);
                System.out.print(a);
            } else
            System.out.print(parameter);
            System.out.print(" ");
        }
        System.out.println();
        for (String alert : alerts)
        {
            try
            {
                double value = Double.parseDouble(alert);
                alert(value);
            }
            catch (NumberFormatException e)
            {
                alert(alert);
            }
        }

    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
