package com.javarush.test.level08.lesson11.bonus01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.util.*;

/* Номер месяца
Программа вводит с клавиатуры имя месяца и выводит его номер на экран в виде: «May is 5 month».
Используйте коллекции.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String month = reader.readLine();
        reader.close();
        System.out.println(month + " is " + getMonthNumber(month) + " month");
    }


        /*
        //Вариант решения через Date.parse(String s), который адекватно парсит название месяца (без учета регистра, иожно сокращать)
        long number = Date.parse(month+" 1 2015") + 1;
        int res = new Date(number).getMonth() + 1;
        System.out.println(month + " is " +res+ " month");
        */


    public static int getMonthNumber(String month)
    {
        ArrayList<String> months = new ArrayList<String>(Arrays.asList("january", "february", "march", "april", "may", "june", "july", "august", "september", "october", "november", "december"));
        //Сравниваем только первые 3 буквы
        String toCompare = month.substring(0, 3).toLowerCase();
        for (int i = 0; i < months.size(); i++)
        {
            if (months.get(i).startsWith(toCompare))
            {
                return i + 1;
            }
        }
        System.out.println("Unrecognisable string!!!");
        return 0;
    }


}
