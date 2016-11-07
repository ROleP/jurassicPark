package com.javarush.test.level08.lesson11.home05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Мама Мыла Раму. Теперь с большой буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа заменяет в тексте первые буквы всех слов на заглавные.
Вывести результат на экран.

Пример ввода:
  мама     мыла раму.

Пример вывода:
  Мама     Мыла Раму.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        //напишите тут ваш код

        //Вычисляем длину строки, чтоб дальше использовать ее как переменную и не считать заново )))
        int textLength = s.length();

        //Т.к. строка известна, то создаем массив символом такой-же длины для записи в него измененной строки посимвольно, превращая в заглавные только первые буквы
        char[] result = new char[textLength];

        //Переменная для определения длины слова
        int newWordLength = 0;

        //Проходим по всем буквам строки
        for (int i = 0; i < textLength; i++)
        {
            char letter = s.charAt(i);

            //Если символ - буква, то увеличиваем длину слова на 1
            if (Character.isLetter(letter))
            {
                newWordLength++;

            }
            else
                newWordLength = 0; //Если символ - не буква, то слово закончилось(или не начиналось ))) ), поэтому ставим длину слова 0

            //Если длина слова 1 - то эта буква - начало слова, увеличиваем ее
            if (newWordLength == 1) letter = Character.toUpperCase(letter);

            //Заносим символ в новый массив, чтобы не потерять ни одного )))
            result[i] = letter;
        }

        System.out.println(result);

        /*
        String[] words = s.split("\\s");
        for (String word : words)
        {
            char[] letters = word.toCharArray();
            letters[0] = Character.toUpperCase(letters[0]);
            //word = letters.toString();
            System.out.println(letters);
        }
        */
    }


}
