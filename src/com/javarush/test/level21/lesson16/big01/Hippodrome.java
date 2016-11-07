package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

/**
 * Created by rolep on 17/11/15.
 */
public class Hippodrome
{

    public static Hippodrome game;

    private ArrayList<Horse> horses = new ArrayList<Horse>();

    public ArrayList<Horse> getHorses()
    {
        return this.horses;
    }

    public void run() throws Exception
    {
        for (int i = 0; i < 100 ; i++)
        {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public void move()
    {
        for (Horse horse : horses)
        {
            horse.move();
        }
    }

    public void print()
    {
        for (Horse horse : horses)
        {
            horse.print();
            System.out.println();
            System.out.println();
        }
    }

    public Horse getWinner()
    {
        Horse winner = getHorses().get(0);
        for (Horse horse : horses)
        {
            if (horse.getDistance() > winner.getDistance())
                winner = horse;
        }
        return winner;
    }

    public void printWinner()
    {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

    public static void main(String[] args) throws Exception
    {
        game = new Hippodrome();
        game.getHorses().add(new Horse("Belka",3,0));
        game.getHorses().add(new Horse("Strelka",3,0));
        game.getHorses().add(new Horse("Flashka",3,0));

        game.run();
        game.printWinner();
    }
}
