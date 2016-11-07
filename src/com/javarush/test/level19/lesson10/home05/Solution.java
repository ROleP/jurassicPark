package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит слова, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(new File(args[0]));
        FileWriter output = new FileWriter(args[1]);
        input.useDelimiter(" ");
        String s;
        while (input.hasNext())
        {
            s=input.next();
            for (int i = 0; i < s.length(); i++)
            {
                if (Character.isDigit(s.charAt(i)))
                {
                    output.write(s+" ");
                    break;
                }
            }
        }
        input.close();
        output.close();
    }
}
