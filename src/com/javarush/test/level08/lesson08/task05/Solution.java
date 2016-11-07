package com.javarush.test.level08.lesson08.task05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        //напишите тут ваш код
        Map<String, String> map = new HashMap<String, String>();
        map.put("A", "BCV");
        map.put("B", "B");
        map.put("AC", "As");
        map.put("Aasd", "B");
        map.put("Awq", "B");
        map.put("Ad", "B");
        map.put("Aqq", "B");
        map.put("Az", "Bxzc");
        map.put("Asssd", "B");
        map.put("Afgg", "B");

        return (HashMap) map;
    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        //напишите тут ваш код
        HashMap<String, Integer> dup = new HashMap<String, Integer>();
        for (String name : map.values())
        {
            if (dup.containsKey(name)) dup.put(name, dup.get(name) + 1);
            else dup.put(name, 1);
        }
        for (Map.Entry<String, Integer> entry : dup.entrySet())
        {
            if (entry.getValue() > 1) removeItemFromMapByValue(map, entry.getKey());
        }

    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }
}
