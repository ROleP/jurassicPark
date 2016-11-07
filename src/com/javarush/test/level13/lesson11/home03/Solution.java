package com.javarush.test.level13.lesson11.home03;

/* Чтение файла
1. Считать с консоли имя файла.
2. Вывести в консоль(на экран) содержимое файла.
3. Не забыть освободить ресурсы. Закрыть поток чтения с файла и поток ввода с клавиатуры.
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        FileInputStream inputStream = new FileInputStream(fileName);

        StringBuilder result = new StringBuilder();

        while (inputStream.available() > 0)
        {
            int i = inputStream.read(); //read next bytes from file

            char[] chars;

            //If bytes are valid unicode symbols, then parse it to chars

            if (Character.isValidCodePoint(i))
            {
                chars = Character.toChars(i);
            }
            // else write them as is
            else
            {
                chars = Integer.toString(i).toCharArray();
            }
            //add chars to resulting string
            result.append(chars);
        }

        System.out.println(result);

        reader.close();
        inputStream.close();

    }
}
