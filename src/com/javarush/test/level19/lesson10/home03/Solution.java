package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader reader = new BufferedReader(new FileReader(new File(args[0])));
        String s;
        SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy");
        int delimiter;
        while ((s=reader.readLine())!=null)
        {
            delimiter = s.lastIndexOf(" ",(s.lastIndexOf(" ",(s.lastIndexOf(" ")-1))-1));
            PEOPLE.add(new Person(s.substring(0,delimiter),sdf.parse(s.substring(delimiter+1))));
        }
        reader.close();
        for (Person person : PEOPLE)
        {
            System.out.print(person.getName());
            System.out.println(" "+person.getBirthday());
        }
    }

}
