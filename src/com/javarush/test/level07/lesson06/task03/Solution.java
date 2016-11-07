package com.javarush.test.level07.lesson06.task03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

/* Самая короткая строка
1. Создай список строк.
2. Считай с клавиатуры 5 строк и добавь в список.
3. Используя цикл, найди самую короткую строку в списке.
4. Выведи найденную строку на экран.
5. Если таких строк несколько, выведи каждую с новой строки.
*/
public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        ArrayList<String> sList = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) sList.add(reader.readLine());
        int minLength = sList.get(0).length();
        Iterator<String> itrA = sList.iterator();
        while (itrA.hasNext())
        {
            String s = itrA.next();
            if (s.length() < minLength) minLength = s.length();
        }
        Iterator<String> itrB = sList.iterator();
        while (itrB.hasNext())
        {
            String s = itrB.next();
            if (s.length() == minLength) System.out.println(s);
        }

    }
}
