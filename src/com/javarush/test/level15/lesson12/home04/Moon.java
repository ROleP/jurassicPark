package com.javarush.test.level15.lesson12.home04;

/**
 * Created by rolep on 25/09/15.
 */
public class Moon implements Planet
{
    private static Moon instance;

    private Moon() {}

    //private static class MoonHelper
    //{
    //   private static final Moon INSTANCE = new Moon();
    //}

    public static Moon getInstance()
    {
        if (instance == null)
            instance = new Moon();
        //return MoonHelper.INSTANCE;
        return instance;
    }
}
