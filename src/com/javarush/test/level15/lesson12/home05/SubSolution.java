package com.javarush.test.level15.lesson12.home05;

/**
 * Created by rolep on 25/09/15.
 */
public class SubSolution extends Solution
{
    public SubSolution(int i)
    {
        super(i);
    }

    public SubSolution()
    {
    }

    public SubSolution(String s)
    {
        super(s);
    }

    protected SubSolution(boolean b)
    {
        super(b);
    }

    protected SubSolution(double d)
    {
        super(d);
    }

    protected SubSolution(float f)
    {
        super(f);
    }

    private SubSolution(int a, int b) { }
    private SubSolution(String a, String b) {}
    private SubSolution(int a, String b) {}

    SubSolution(Object s)
    {
        super(s);
    }

    SubSolution(int a, Object b)
    {
        super(a, b);
    }

    SubSolution(Object a, int b)
    {
        super(a, b);
    }
}
