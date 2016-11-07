package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        switch (args[0])
        {
            case "-u" : updateAction(fileName, args);
                break;
            case "-d" : deleteAction(fileName, args);
                break;
            default : System.out.println("No supported argument provided!!!");
                break;
        }
    }
    private static void updateAction(String fileName, String[] args) throws IOException
    {
        String nl = System.getProperty("line.separator");
        short quantity = Short.parseShort(args[args.length - 1]);
        float price = Float.parseFloat(args[args.length - 2]);
        StringBuilder productName = new StringBuilder();
        //Appending Product Name, parsed from args, to product-string
        for (int i = 2; i < args.length - 2; i++)
        {
            if (i > 2) productName.append(" ");
            productName.append(args[i]);
        }
        StringBuilder id = new StringBuilder(args[1]);
        while (id.length()<8) id.append(" ");
        StringBuilder product = new StringBuilder();
        product.append(id);
        product.append(productName);
        while (product.length()<38) product.append(" ");
        product.append(price);
        while (product.length()<46) product.append(" ");
        product.append(quantity);
        while (product.length()<50) product.append(" ");
        product.append(nl);

        File file = new File(fileName);
        File tempFile = new File(fileName+".tmp");
        FileReader reader = new FileReader(file);
        FileWriter writer = new FileWriter(tempFile);
        char[] charBuff = new char[51];
        while (reader.ready())
        {
            reader.read(charBuff);
            int eq = 0;
            for (int i = 0; i < id.length(); i++)
            {
                if (charBuff[i] != id.charAt(i)) break;
                eq++;
            }
            if (eq==id.length())
            {
                writer.write(product.toString());
                writer.write(nl);
                continue;
            }
            writer.write(charBuff);
            //writer.write(nl);
        }
        reader.close();
        writer.close();
        tempFile.renameTo(file);
    }
    private static void deleteAction(String fileName, String[] args) throws IOException
    {
        //String nl = System.getProperty("line.separator");
        //short quantity = Short.parseShort(args[args.length - 1]);
        //float price = Float.parseFloat(args[args.length - 2]);
        //StringBuilder productName = new StringBuilder();
        //Appending Product Name, parsed from args, to product-string
        //for (int i = 2; i < args.length - 2; i++)
        //{
        //    if (i > 2) productName.append(" ");
        //    productName.append(args[i]);
        //}
        StringBuilder id = new StringBuilder(args[1]);
        while (id.length()<8) id.append(" ");
        //StringBuilder product = new StringBuilder();
        //product.append(id);
        //product.append(productName);
        //while (product.length()<38) product.append(" ");
        //product.append(price);
        //while (product.length()<46) product.append(" ");
        //product.append(quantity);
        //while (product.length()<50) product.append(" ");
        //product.append(nl);

        File file = new File(fileName);
        File tempFile = new File(fileName+".tmp");
        FileReader reader = new FileReader(file);
        FileWriter writer = new FileWriter(tempFile);
        char[] charBuff = new char[51];
        while (reader.ready())
        {
            reader.read(charBuff);
            int eq = 0;
            for (int i = 0; i < id.length(); i++)
            {
                if (charBuff[i] != id.charAt(i)) break;
                eq++;
            }
            if (eq==id.length())
            {
                continue;
            }
            writer.write(charBuff);
            //writer.write(nl);
        }
        reader.close();
        writer.close();
        tempFile.renameTo(file);
    }
}
