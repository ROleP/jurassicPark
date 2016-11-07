package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Solution {
    public static void main(String[] args) throws IOException{
        switch (args[0])
        {
            case "-e" : encrypt(true, args[1], args[2]);
                break;
            case "-d" : encrypt(false, args[1], args[2]);
                break;
            default :
                System.out.println("Invalid key!!! Use '-e' to encrypt and '-d' to decrypt.");
                return;
        }
    }

    private static void encrypt(boolean enc, String fileIn, String fileOut) throws IOException
    {
        byte[] key = "jzxc!_=dm5d:;5dtP@s$w0rD.,/1sd3wfsIUFV%&fdsfksb5avktdcl4vrfcRR<S".getBytes(StandardCharsets.UTF_8);
        int encDec = enc ? 1 : -1;
        try
        {
            FileInputStream fis = new FileInputStream(fileIn);
            FileOutputStream fos = new FileOutputStream(fileOut);
            byte[] buffer = new byte[1024];
            while (fis.available()>0)
            {
                int length = fis.read(buffer);
                int j = 0; //Index of byte in key
                for (int i = 0; i < length; i++)
                {
                    try
                    {
                        buffer[i] += (key[j] * encDec);
                        j++;
                    }
                    catch (ArrayIndexOutOfBoundsException e)
                    {
                        j = 0;
                        i--;
                    }
                }
                fos.write(buffer, 0, length);
            }
            fis.close();
            fos.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Bad filepaths provided!!!");
        }
    }

}
