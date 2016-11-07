package com.javarush.test.level19.lesson03.task04;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950

В файле хранится большое количество людей, данные одного человека находятся в одной строке. Метод read() должен читать данные одного человека.
*/

public class Solution {
    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner scanner;
        public PersonScannerAdapter(Scanner scanner)
        {
            this.scanner= scanner;
        }

        @Override
        public Person read() throws IOException
        {
            String[] fields = scanner.nextLine().split(" ");
            SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
            Date bday = null;
            try
            {
                bday = sdf.parse(fields[3] + fields[4] + fields[5]);
            } catch (ParseException e) {}
            return new Person(fields[1],fields[2],fields[0],bday);
        }

        @Override
        public void close() throws IOException
        {
            scanner.close();
        }
    }
}
