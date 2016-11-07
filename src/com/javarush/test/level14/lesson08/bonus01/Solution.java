package com.javarush.test.level14.lesson08.bonus01;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args)
    {
        initExceptions();

        for (Exception exception : exceptions)
        {
            System.out.println(exception);
        }
    }

    private static void initExceptions()
    {   //it's first exception
        try
        {
            float i = 1 / 0;

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        //Add your code here
        try
        {
            int[] a = new int[0];
            int b = a[1];
        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            ArrayList a = new ArrayList();
            a.get(4);
        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            String a = "asd";
            int b = Integer.parseInt(a);
        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            FileInputStream a = new FileInputStream("asd");
            a.read();
        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            ArrayList<Integer> a = new ArrayList();
            a.add(null);
            Integer b = a.get(0) + 1;
        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            class Aqwe
            {

            }

            class Bqwe extends Aqwe
            {

            }

            class Cqwe extends Aqwe
            {

            }

            Aqwe a = new Bqwe();
            Cqwe c = (Cqwe) a;

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            Date lowDate = sdf.parse("test");
        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            Solution test = new Solution();
            test.clone();
        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            Object i = new Integer(0);
            System.out.print((String) i);
        } catch (Exception e)
        {
            exceptions.add(e);
        }
    }
}
