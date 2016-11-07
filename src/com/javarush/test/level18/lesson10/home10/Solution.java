package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> fileNames = new LinkedList<String>();
        List<Integer> fileNumberList = new LinkedList<Integer>();
        String s;
        String fileName = "";
        outer:
        while (!(s=reader.readLine()).equals("end"))
        {
            if (fileName.isEmpty()) fileName = s.substring(0, s.lastIndexOf("part")-1);
            int id = Integer.parseInt(s.substring(s.lastIndexOf("part")+4));
            for (int i = 0; i < fileNumberList.size(); i++)
            {
                if (id < fileNumberList.get(i))
                {
                    fileNames.add(i, s);
                    fileNumberList.add(i, id);
                    continue outer;
                }
            }
            fileNames.add(s);
            fileNumberList.add(id);
        }
        reader.close();

        FileOutputStream fos = new FileOutputStream(fileName);
        byte[] buffer = new byte[1024];

        for (int i = 0; i < fileNames.size(); i++)
        {
            FileInputStream fis = new FileInputStream(fileNames.get(i));
            while (fis.available()>0)
            {
                int length = fis.read(buffer);
                fos.write(buffer, 0, length);
            }
            fis.close();
        }
        fos.close();
    }
}
