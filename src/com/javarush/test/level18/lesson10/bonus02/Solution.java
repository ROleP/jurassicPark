package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        switch (args[0])
        {
            case "-c" : createAction(fileName, args);
                break;
            default : System.out.println("No supported argument provided!!!");
                break;
        }
    }

    private static void createAction(String fileName, String[] args)
    {
        short quantity = Short.parseShort(args[args.length - 1]);
        float price = Float.parseFloat(args[args.length - 2]);
        StringBuilder productName = new StringBuilder();
        //Appending Product Name, parsed from args, to product-string
        for (int i = 1; i < args.length - 2; i++)
        {
            if (i > 1) productName.append(" ");
            productName.append(args[i]);
        }
        //Getting maxId from file
        int maxId = 0;
        try
        {
            Scanner sc = new Scanner(new File(fileName));
            int id = 0;
            while (sc.hasNextLine())
            {
                String s = sc.findWithinHorizon("(\\d+)", 8);
                if (s != null) id = Integer.parseInt(s);
                if (id > maxId) maxId = id;
                sc.nextLine();
            }
            sc.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Bad file name provided!!!");
            return;
        }
        StringBuilder product = new StringBuilder();
        product.append(maxId+1);
        while (product.length()<8) product.append(" ");
        product.append(productName);
        while (product.length()<38) product.append(" ");
        product.append(price);
        while (product.length()<46) product.append(" ");
        product.append(quantity);
        while (product.length()<50) product.append(" ");
        System.out.println(product);
        try
        {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            writer.append(product);
            writer.close();
        }
        catch (IOException e) {}
    }
}
