package com.javarush.test.level18.lesson10.home08;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true)
        {
            String fileName = reader.readLine();
            if ("exit".equals(fileName)) break;
            Thread t = new ReadThread(fileName);
            t.start();
            t.join();
        }
        reader.close();
        /*
        for (Map.Entry<String, Integer> stringIntegerEntry : resultMap.entrySet())
        {
            System.out.println(stringIntegerEntry.getKey()+" - " + stringIntegerEntry.getValue());
        }
        */
    }

    public static class ReadThread extends Thread {
        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }

        private String fileName;
        private Integer bigByte;
        // implement file reading here - реализуйте чтение из файла тут
        public void run()
        {
            int[] bytes = new int[256];
            int max = 0;
            int maxIndex= 0;
            for (int aByte : bytes)
            {
                aByte = 0;
            }
            try
            {
                FileInputStream fis = new FileInputStream(fileName);
                while (fis.available()>0)
                {
                    int i = fis.read();
                    bytes[i]++;
                }
                fis.close();
            }
            catch (IOException e) { }
            for (int i = 0; i < bytes.length; i++)
            {
                if (bytes[i] > max)
                {
                    max = bytes[i];
                    maxIndex = i;
                }
            }
            bigByte = maxIndex;
            //synchronized (resultMap)
            {
                resultMap.put(this.fileName, this.bigByte);
            }
        }
    }
}
