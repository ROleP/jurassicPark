package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.kitchen.Waitor;

/**
 * Created by rolep on 21/01/16.
 */
public class Restaurant
{
    public static void main(String[] args)
    {
        Cook mcDuck = new Cook("McDonald");
        Waitor waitor = new Waitor();
        Tablet tablet = new Tablet(5);
        tablet.addObserver(mcDuck);
        mcDuck.addObserver(waitor);
        tablet.createOrder();
    }
}
