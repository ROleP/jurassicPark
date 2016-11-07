package com.javarush.test.level22.lesson09.task03;

import java.io.*;
import java.util.*;

/* Составить цепочку слов
В методе main считайте с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставить все слова в таком порядке,
чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.
В файле не обязательно будет много слов.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //...
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        reader.close();
        List<String> input = new ArrayList<String>();
        BufferedReader fileReader = new BufferedReader(new FileReader(filename));
        while (fileReader.ready())
            input.addAll(Arrays.asList(fileReader.readLine().split(" ")));
        fileReader.close();
        String[] words = new String[input.size()];
        input.toArray(words);
        StringBuilder result = getLine(words);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        if (words == null || words.length == 0)
            return new StringBuilder("");
        List<String> internal = new LinkedList<String>();
        Collections.addAll(internal, words);
        outer:
        while (true)
        {
            for (int i = 0; i < internal.size()-1; i++)
            {
                if (internal.get(i).toLowerCase().charAt(internal.get(i).length()-1) == internal.get(i+1).toLowerCase().charAt(0))
                    continue;
                Collections.shuffle(internal);
                continue outer;
            }
            StringBuilder result = new StringBuilder();
            for (String s : internal)
            {
                result.append(s+" ");
            }
            result.deleteCharAt(result.length()-1);
            return result;
        }
    }
}
