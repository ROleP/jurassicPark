package com.javarush.test.level31.lesson02.home02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/* Находим все файлы
Реализовать логику метода getFileTree, который должен в директории root найти список всех файлов включая вложенные.
Используйте очередь, рекурсию не используйте.
Верните список всех путей к найденным файлам, путь к директориям возвращать не надо.
Путь должен быть абсолютный.
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> files = new LinkedList<>();
        Queue<Path> directories = new LinkedBlockingQueue<>();
        Path currentDirectory = Paths.get(root);
        do {
            for (Path file : Files.newDirectoryStream(currentDirectory)) {
                if (Files.isDirectory(file)) {
                    directories.offer(file);
                } else {
                    files.add(file.toAbsolutePath().toString());
                }
            }
            currentDirectory = directories.poll();
        } while (currentDirectory !=null);
        return files;
    }
}
