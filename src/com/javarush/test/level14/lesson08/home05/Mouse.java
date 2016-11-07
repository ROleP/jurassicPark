package com.javarush.test.level14.lesson08.home05;

/**
 * Created by rolep on 22.09.15.
 */
public class Mouse implements CompItem
{
    public String getName()
    {
        return this.getClass().getSimpleName();
    }
}
