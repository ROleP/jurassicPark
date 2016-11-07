package com.javarush.test.level15.lesson12.home04;

/**
 * Created by rolep on 25/09/15.
 */
public class Sun implements Planet
{
    private static Sun instance;

    private Sun() {}

    //private static class SunHelper
    //{
    //    private static final Sun INSTANCE = new Sun();
    //}

    public static Sun getInstance()
    {
        if (instance == null)
            instance = new Sun();
        //return SunHelper.INSTANCE;
        return instance;
    }
}
