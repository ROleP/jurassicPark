package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rolep on 23/01/16.
 */
public class ConsoleHelper
{
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message)
    {
        System.out.println(message);
    }

    public static String readString() throws IOException
    {
        String s = reader.readLine();
        return s;
    }

    public static List<Dish> getAllDishesForOrder() throws IOException
    {
        List<Dish> dishes = new ArrayList<>();
        writeMessage("Please, choose desired dish. Menu: " + Dish.allDishesToString());
        while (true)
        {
            String choice = readString();
            if (choice.equals("exit"))
                break;
            try
            {
                dishes.add(Dish.valueOf(choice));
            }
            catch (IllegalArgumentException e)
            {
                writeMessage(choice + " is not detected");
            }
        }
        return dishes;
    }
}
