package com.javarush.test.level14.lesson06.home01;

/**
 * Created by rolep on 21/09/15.
 */
public class MoldovanHen extends Hen
{
    int getCountOfEggsPerMonth()
        {
            return 2;
        }
        String getDescription()
        {
            return super.getDescription() + " Моя страна - " + Country.MOLDOVA + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
        }
}
