package com.javarush.test.level22.lesson05.task01;

import java.util.regex.Pattern;

/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        if (string == null)
            throw new TooShortStringException();
        int firstSpace = string.indexOf(" ");
        if (firstSpace == -1)
            throw new TooShortStringException();
        int fourthSpace = firstSpace;
        for (int i = 0; i < 3; i++)
        {
            fourthSpace = string.indexOf(" ", fourthSpace + 1);
            System.out.println(fourthSpace);
            if (fourthSpace == -1)
                throw new TooShortStringException();
        }
        String lastWords = string.substring(fourthSpace+1);
        System.out.println(lastWords);
        String[] words = lastWords.split("([\\s])", 0);
        System.out.println(words.length);
        System.out.println(words[0]);
        return string.substring(firstSpace+1, fourthSpace + 1) + words[0];
    }

    public static class TooShortStringException extends Exception {

    }

    public static void main(String[] args) throws Exception
    {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }
}
