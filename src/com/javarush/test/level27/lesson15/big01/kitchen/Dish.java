package com.javarush.test.level27.lesson15.big01.kitchen;

import java.util.Arrays;

/**
 * Created by rolep on 21/01/16.
 */
public enum Dish
{
    Fish(25),
    Steak(30),
    Soup(15),
    Juice(5),
    Water(3);

    private int duration;

    Dish(int duration)
    {
        this.duration = duration;
    }

    public static String allDishesToString()
    {
        StringBuilder result = new StringBuilder(Arrays.toString(values()));
        result.delete(result.length() - 1, result.length());
        result.delete(0, 1);
        return result.toString();

    }

    public int getDuration()
    {
        return duration;
    }
}
