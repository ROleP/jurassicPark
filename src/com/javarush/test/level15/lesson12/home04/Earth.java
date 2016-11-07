package com.javarush.test.level15.lesson12.home04;

/**
 * Created by rolep on 25/09/15.
 */
public class Earth implements Planet
{
    private static Earth instance;

    private Earth() {}

    //private static class EarthHelper
    //{
    //    private static final Earth INSTANCE = new Earth();
    //}

    public static Earth getInstance()
    {
        if (instance == null)
            instance = new Earth();
        //return EarthHelper.INSTANCE;
        return instance;
    }
}
