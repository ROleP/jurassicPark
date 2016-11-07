package com.javarush.test.level19.lesson10.bonus03;

/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат
Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span><span>Super</span><span>girl</span>
Первым параметром в метод main приходит тег. Например, "span"
Вывести на консоль все теги, которые соответствуют заданному тегу
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
Количество пробелов, \n, \r не влияют на результат
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
Тег может содержать вложенные теги
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>
<span>Super</span>
<span>girl</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String fileName = reader.readLine();

            String text = new Scanner(new File(fileName)).useDelimiter("\\Z").next();

            List<String> strings = getTags(args[0], text);

            for (String string : strings) {
                System.out.println(string);
            }

        }
        catch (Exception e) {}

    }

    public static List<String> getTags(String tag, String text) {

        text = text.replace("\r", "").replace("\n", "");

        List<int[]> tags = new ArrayList<>();
        int tagStart = -1;
        int tagEnd = 0;

        List<String> stringTags = new ArrayList<>();

        while (true) {
            tagStart = text.indexOf("<"+tag, tagStart+1);
            if (tagStart == -1) break;
            if (Character.isLetter(text.charAt(tagStart+tag.length()+1))) {
                System.out.println(Character.isLetter(text.charAt(tagStart+tag.length()+1)));
                tagStart++;
                continue;
            }
            tags.add(new int[]{tagStart, -1});
        }

        while (true) {
            tagEnd = text.indexOf("</"+tag+">", tagEnd+1);
            if (tagEnd == -1) break;

            for (int i = 0; i < tags.size(); i++) {
                int[] coords = tags.get(i);
                if (coords[0] < tagEnd) {
                    if (i == tags.size()-1) {
                        for (int j = i; j >= 0; j--) {
                            int[] m = tags.get(j);
                            if (m[1] == -1) {
                                m[1] = tagEnd;
                                break;
                            }
                        }
                    }
                }

                else {
                    for (int j = i-1; j >= 0; j--) {
                        int[] m = tags.get(j);
                        if (m[1] == -1) {
                            m[1] = tagEnd;
                            break;
                        }
                    }
                    break;
                }
            }
        }

        for (int[] ints : tags) {
            if (ints[1] == -1) ints[1] = text.length()-1-tag.length()-2;
            stringTags.add(text.substring(ints[0], ints[1]+tag.length()+3));
        }

        return stringTags;
    }
}
