package com.javarush.test.level22.lesson05.task02;

/* Между табуляциями
Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
На некорректные данные бросить исключение TooShortStringException.
Класс TooShortStringException не менять.
*/
public class Solution {
    public static String getPartOfString(String string) throws Exception {
        try
        {
            int firstTab = string.indexOf("\t");
            if (firstTab == -1)
                return string;

            return string.substring(firstTab+1, string.indexOf("\t", firstTab+1));
        } catch (Exception e) {
            throw new TooShortStringException(); }
    }

    public static class TooShortStringException extends Exception {
    }
}
