package com.javarush.test.level26.lesson15.big01;

/**
 * Created by rolep on 07/01/16.
 */
public enum Operation
{
    LOGIN,
    INFO,
    DEPOSIT,
    WITHDRAW,
    EXIT;

    public static Operation getAllowableOperationByOrdinal(Integer i)
    {
        switch (i)
        {
            case 0: throw new IllegalArgumentException();
            case 1: return INFO;
            case 2: return DEPOSIT;
            case 3: return WITHDRAW;
            case 4: return EXIT;
            default: throw new IllegalArgumentException();
        }
    }
}
