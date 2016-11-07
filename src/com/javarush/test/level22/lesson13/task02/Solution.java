package com.javarush.test.level22.lesson13.task02;

import java.io.*;
import java.nio.Buffer;
import java.nio.charset.Charset;

/* Смена кодировки
В метод main первым параметром приходит имя файла, тело которого в кодировке Windows-1251.
В метод main вторым параметром приходит имя файла, в который необходимо записать содержимое первого файла в кодировке UTF-8.
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(args[0]);
        FileOutputStream fos = new FileOutputStream(args[1]);
        byte[] buffer = new byte[1000];
        Charset win1251 = Charset.forName("Windows-1251");
        Charset utf8 = Charset.forName("UTF-8");
        while (fis.available()>0)
        {
            int c = fis.read(buffer);
            String s = new String(buffer, 0, c, utf8);
            //System.out.println(s);
            byte[] buff = s.getBytes(win1251);
            fos.write(buff);
            fos.flush();
        }
        //System.out.println(new String(buffer));
        fis.close();
        fos.close();
    }
}
