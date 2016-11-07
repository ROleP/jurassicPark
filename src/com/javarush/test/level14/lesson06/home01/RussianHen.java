package com.javarush.test.level14.lesson06.home01;

/**
 * Created by rolep on 21/09/15.
 */
public class RussianHen extends Hen
{
    int getCountOfEggsPerMonth()
        {
            return 3;
        }
        String getDescription()
        {
            return super.getDescription() + " Моя страна - " + Country.RUSSIA + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
        }
}
