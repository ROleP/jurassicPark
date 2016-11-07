package com.javarush.test.level15.lesson12.bonus02;

/**
 * Created by rolep on 25/09/15.
 */
public abstract class DrinkMaker
{
    abstract void getRightCup();
    abstract void putIngredient();
    abstract void pour();

    void makeDrink()
    {
        getRightCup();
        putIngredient();
        pour();
    }
}
