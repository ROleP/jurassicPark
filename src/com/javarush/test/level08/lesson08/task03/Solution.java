package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.Map;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        //напишите тут ваш код
        Map<String, String> map = new HashMap<String, String>();
        map.put("Иванов", "Иван");
        map.put("Иванова", "Иванна");
        map.put("Сергеев", "Сегей");
        map.put("Борисов", "Денис");
        map.put("Высокий", "Иван");
        map.put("Быстрая", "Анна");
        map.put("Ждан", "Юлия");
        map.put("Ротманс", "Инесса");
        map.put("Курт", "Кобейн");
        map.put("Лок", "Док");
        return (HashMap) map;

    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        //напишите тут ваш код
        int count = 0;
        for (String entry : map.values())
        {
            if (entry.equals(name)) count++;
        }
        return count;

    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String familiya)
    {
        //напишите тут ваш код
        int count = 0;
        for (String key : map.keySet())
        {
            if (key.equals(familiya)) count++;
        }
        return count;

    }
}
