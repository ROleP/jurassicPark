package com.javarush.test.level28.lesson06.home01;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by rolep on 03/02/16.
 */
public class MyThread extends Thread
{
    private static AtomicInteger priorityRoll = new AtomicInteger(1);

    private void setThisThreadPriority()
    {
        if (priorityRoll.weakCompareAndSet(10, 1))
            this.setPriority(10);
        else this.setPriority(priorityRoll.getAndIncrement());
    }

    public MyThread()
    {
        setThisThreadPriority();
    }

    public MyThread(Runnable target)
    {
        super(target);
        setThisThreadPriority();
    }

    public MyThread(ThreadGroup group, Runnable target)
    {
        super(group, target);
        setThisThreadPriority();
    }

    public MyThread(String name)
    {
        super(name);
        setThisThreadPriority();
    }

    public MyThread(ThreadGroup group, String name)
    {
        super(group, name);
        setThisThreadPriority();
    }

    public MyThread(Runnable target, String name)
    {
        super(target, name);
        setThisThreadPriority();
    }

    public MyThread(ThreadGroup group, Runnable target, String name)
    {
        super(group, target, name);
        setThisThreadPriority();
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize)
    {
        super(group, target, name, stackSize);
        setThisThreadPriority();
    }
}
