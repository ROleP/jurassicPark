package com.javarush.test.level08.lesson08.task01;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* 20 слов на букву «Л»
Создать множество строк (Set<String>), занести в него 20 слов на букву «Л».
*/

public class Solution
{
    public static HashSet<String> createSet()
    {
        //напишите тут ваш код
        Set<String> set = new HashSet<String>();
        Collections.addAll(set, "Лист1", "Лист2", "Лист3", "Лист4", "Лист5", "Лист6", "Лист7", "Лист8", "Лист9", "Лист10", "Лист11", "Лист12", "Лист13", "Лист14", "Лист15", "Лист16", "Лист17", "Лист18", "Лист19", "Лист20");
        return (HashSet) set;
    }
}
