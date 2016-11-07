package com.javarush.test.level21.lesson16.big01;

/**
 * Created by rolep on 17/11/15.
 */
public class Horse
{
    private String name;
    private double speed;
    private double distance;

    public String getName()
    {
        return name;
    }

    public double getDistance()
    {
        return distance;
    }

    public double getSpeed()
    {
        return speed;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setSpeed(double speed)
    {
        this.speed = speed;
    }

    public void setDistance(double distance)
    {
        this.distance = distance;
    }

    public Horse(String name, double speed, double distance)
    {
        this.setName(name);
        this.setSpeed(speed);
        this.setDistance(distance);
    }

    public void move()
    {
        setDistance(getDistance() + Math.random() * getSpeed());
    }

    public void print()
    {
        int dots = (int)getDistance();
        for (int i = 0; i < dots; i++)
        {
            System.out.print(".");
        }
        System.out.println(getName());
    }
}
