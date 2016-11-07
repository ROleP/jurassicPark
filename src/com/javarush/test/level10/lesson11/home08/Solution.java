package com.javarush.test.level10.lesson11.home08;

import java.util.ArrayList;

/* Массив списков строк
Создать массив, элементами которого будут списки строк. Заполнить массив любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<String>[] arrayOfStringList = createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList()
    {
        //напишите тут ваш код
        ArrayList<String>[] list = new ArrayList[3];
        ArrayList<String> list1 = new ArrayList<String>();
        list1.add("kyfkfffhgkhg");
        list[0] = list1;
        ArrayList<String> list2 = new ArrayList<String>();
        list2.add("kyfkfffhgkhg");
        list[1] = list2;
        ArrayList<String> list3 = new ArrayList<String>();
        list3.add("kyfkfffhgkhg");
        list[2] = list3;

        return list;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList)
    {
        for (ArrayList<String> list : arrayOfStringList)
        {
            for (String s : list)
            {
                System.out.println(s);
            }
        }
    }
}