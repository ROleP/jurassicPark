package com.javarush.test.level08.lesson08.task04;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{
    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", new Date("JUNE 1 1980"));

        //напишите тут ваш код

        map.put("AStallone", new Date("JUNE 1 1980"));
        map.put("BStallone", new Date("JUNE 1 1980"));
        map.put("ZStallone", new Date("JUNE 1 1980"));
        map.put("XStallone", new Date("JUNE 1 1980"));
        map.put("CStallone", new Date("JUNE 1 1980"));
        map.put("VStallone", new Date("MAY 1 1980"));
        map.put("BStallone", new Date("JUNE 1 1980"));
        map.put("NStallone", new Date("JUNE 1 1980"));
        map.put("MStallone", new Date("JANUARY 1 1980"));
        map.put("pMStallone", new Date("JANUARY 1 1980"));

        return map;

    }

    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {
        //напишите тут ваш код
        Iterator<Map.Entry<String, Date>> iter = map.entrySet().iterator();
        while (iter.hasNext())
        {
            Map.Entry<String, Date> entry = iter.next();
            Date d = entry.getValue();
            if (d.getMonth() > 4 && d.getMonth() < 8) iter.remove();
        }

    }

    public static void main(String[] args)
    {
        HashMap<String, Date> map = createMap();
        removeAllSummerPeople(map);

    }
}
