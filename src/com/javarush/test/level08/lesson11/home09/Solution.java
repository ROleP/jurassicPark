package com.javarush.test.level08.lesson11.home09;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;

/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
Не забудьте учесть первый день года.
Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false
*/

public class Solution
{
    public static void main(String[] args)
    {
        System.out.println(isDateOdd("JANUARY 1 2000"));

        System.out.println(isDateOdd("JANUARY 2 2020"));
    }

    public static boolean isDateOdd(String date)
    {
        Date test = new Date(date);
        Date yearStart = new Date();
        yearStart.setYear(test.getYear());
        yearStart.setMonth(0);
        yearStart.setDate(1);
        yearStart.setHours(0);
        yearStart.setMinutes(0);
        yearStart.setSeconds(0);
        int dayMsec = 24 * 60 * 60 * 1000;
        long diff = test.getTime() - yearStart.getTime();
        int days = (int) (diff / dayMsec);
        return !(days % 2 == 0);
    }
}
