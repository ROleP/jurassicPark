package com.javarush.test.level14.lesson06.home01;

/**
 * Created by rolep on 21/09/15.
 */
public class UkrainianHen extends Hen
{
    int getCountOfEggsPerMonth()
        {
            return 7;
        }
        String getDescription()
        {
            return super.getDescription() + " Моя страна - " + Country.UKRAINE + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
        }
}
