package com.javarush.test.level14.lesson06.home01;

/**
 * Created by rolep on 21/09/15.
 */
public class BelarusianHen extends Hen
{
    int getCountOfEggsPerMonth()
        {
            return 6;
        }
        String getDescription()
        {
            return super.getDescription() + " Моя страна - " + Country.BELARUS + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
        }
}
