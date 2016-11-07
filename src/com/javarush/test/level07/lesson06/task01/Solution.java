package com.javarush.test.level07.lesson06.task01;

import java.util.ArrayList;
import java.util.Iterator;

/* 5 различных строчек в списке
1. Создай список строк.
2. Добавь в него 5 различных строчек.
3. Выведи его размер на экран.
4. Используя цикл выведи его содержимое на экран, каждое значение с новой строки.
*/
public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        ArrayList<String> sList = new ArrayList<String>();
        sList.add("One");
        sList.add("Two");
        sList.add("Three");
        sList.add("Four");
        sList.add("Five");
        System.out.println(sList.size());
        Iterator<String> itr = sList.iterator();
        while (itr.hasNext())
        {
            System.out.println(itr.next());
        }
    }
}
