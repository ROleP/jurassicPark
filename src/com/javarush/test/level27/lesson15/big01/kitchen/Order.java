package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.Tablet;

import java.io.IOException;
import java.util.List;

/**
 * Created by rolep on 21/01/16.
 */
public class Order
{
    private final Tablet tablet;
    private List<Dish> dishes;

    public Order(Tablet tablet) throws IOException
    {
        this.tablet = tablet;
        this.dishes = ConsoleHelper.getAllDishesForOrder();
    }

    @Override
    public String toString()
    {
        String result = "";
        if (dishes.size() > 0)
            result = "Your order: " + dishes.toString() +
                " of " + tablet.toString();
        return result;
    }

    public int getTotalCookingTime()
    {
        int totalCookingDuration = 0;
        for (Dish dish : dishes)
        {
            totalCookingDuration += dish.getDuration();
        }
        return totalCookingDuration;
    }

    public boolean isEmpty()
    {
        return dishes.isEmpty();
    }
}
