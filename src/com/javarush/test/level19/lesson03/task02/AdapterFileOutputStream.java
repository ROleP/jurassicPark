package com.javarush.test.level19.lesson03.task02;

/* Адаптер
Используйте класс AdapterFileOutputStream, чтобы адаптировать FileOutputStream к новому интерфейсу AmigoStringWriter
*/

import java.io.FileOutputStream;
import java.io.IOException;

public class AdapterFileOutputStream implements AmigoStringWriter {
    private FileOutputStream fos;
    public AdapterFileOutputStream(FileOutputStream fos)
    {
        this.fos = fos;
    }
    public void flush() throws IOException
    {
        fos.flush();
    }
    public void writeString(String s) throws IOException
    {
        fos.write(s.getBytes());
    }
    public void close() throws IOException
    {
        fos.close();
    }
}

