package com.javarush.test.level29.lesson15.big01.car;

/**
 * Created by rolep on 19/02/16.
 */
public class Sedan extends Car
{
    public Sedan(int numberOfPassengers)
    {
        super(Car.SEDAN, numberOfPassengers);
    }

    public int getMaxSpeed()
    {
        final int MAX_SEDAN_SPEED = 120;
        return MAX_SEDAN_SPEED;
    }
}
