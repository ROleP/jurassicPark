package com.javarush.test.level31.lesson06.home01;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.*;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* Добавление файла в архив
В метод main приходит список аргументов.
Первый аргумент - полный путь к файлу fileName.
Второй аргумент - путь к zip-архиву.
Добавить файл (fileName) внутрь архива в директорию 'new'.
Если в архиве есть файл с таким именем, то заменить его.

Пример входных данных:
C:/result.mp3
C:/pathToTest/test.zip

Файлы внутри test.zip:
a.txt
b.txt

После запуска Solution.main архив test.zip должен иметь такое содержимое:
new/result.mp3
a.txt
b.txt

Подсказка: нужно сначала куда-то сохранить содержимое всех энтри,
а потом записать в архив все энтри вместе с добавленным файлом.
Пользоваться файловой системой нельзя.
*/
public class Solution {
    public static void main(String[] args) throws IOException {

        Path fileName = Paths.get(args[0]);
        Path zipPath = Paths.get(args[1]);
        Path temp = Files.createTempDirectory("zip-temp");

        Map<String, byte[]> origs = new HashMap<>();

        try (ZipInputStream is = new ZipInputStream(Files.newInputStream(zipPath))) {

            ZipEntry entry = is.getNextEntry();

            while (entry != null) {
                String entryName = entry.getName();
                origs.put(entryName, new byte[(int)entry.getSize()]);
                Path entryTempFullPath = temp.resolve(Paths.get(entryName));

                try (OutputStream os = new ByteArrayOutputStream()) {
                   copyData(is, os);
                }
                entry = is.getNextEntry();
            }

        }

        Path fileTempFullPath = temp.resolve("new").resolve(fileName.getFileName());

        Files.copy(fileName, fileTempFullPath, StandardCopyOption.REPLACE_EXISTING);


    }

    private static void copyData(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[8 * 1024];
        int len;
        while ((len = in.read(buffer)) > 0) {
            out.write(buffer, 0, len);
        }
    }
}
