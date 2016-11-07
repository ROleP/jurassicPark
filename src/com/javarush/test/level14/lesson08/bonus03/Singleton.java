package com.javarush.test.level14.lesson08.bonus03;

/**
 * Created by rolep on 23.09.15.
 */
public class Singleton
{
    /*
    public static Singleton getInstance()
    {
        return SingletonHolder.HOLDER_INSTANCE;
    }

    private Singleton() {}

    public static class SingletonHolder
    {
        public static final Singleton HOLDER_INSTANCE = new Singleton();
    }
    */
    private Singleton() {}

    public static Singleton instance;

    public static Singleton getInstance()
    {
        if (instance == null)
            instance = new Singleton();
        return instance;
    }
}
