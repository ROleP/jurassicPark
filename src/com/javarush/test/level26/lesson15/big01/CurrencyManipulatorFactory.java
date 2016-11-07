package com.javarush.test.level26.lesson15.big01;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by rolep on 07/01/16.
 */
public class CurrencyManipulatorFactory
{
    private static Set<CurrencyManipulator> manipulators = new HashSet();

    public static Collection<CurrencyManipulator> getAllCurrencyManipulators()
    {
        return manipulators;
    }

    private CurrencyManipulatorFactory(){}

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode)
    {
        for (CurrencyManipulator manipulator : manipulators)
        {
            if (manipulator.getCurrencyCode().equals(currencyCode))
                return manipulator;
        }
        CurrencyManipulator manipulator = new CurrencyManipulator(currencyCode);
        manipulators.add(manipulator);
        return manipulator;
    }
}
