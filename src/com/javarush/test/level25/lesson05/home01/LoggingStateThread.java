package com.javarush.test.level25.lesson05.home01;

/**
 * Created by rolep on 11/12/15.
 */
public class LoggingStateThread extends Thread
{
    State state;
    Thread ttt;

    public LoggingStateThread(Thread t)
    {
        this.ttt = t;
        setDaemon(true);
    }

    public void run()
    {
            while (!isInterrupted())
            {
                if (ttt.getState() != state)
                {
                    state = ttt.getState();
                    System.out.println(state);
                }
                    if (state == State.TERMINATED)
                        this.interrupt();

            }
    }
}
