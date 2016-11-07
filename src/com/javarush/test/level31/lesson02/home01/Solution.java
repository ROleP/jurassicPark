package com.javarush.test.level31.lesson02.home01;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

/* Проход по дереву файлов
1. На вход метода main подаются два параметра.
Первый - path - путь к директории, второй - resultFileAbsolutePath - имя файла, который будет содержать результат.
2. Для каждого файла в директории path и в ее всех вложенных поддиректориях выполнить следующее:
2.1. Если у файла длина в байтах больше 50, то удалить его.
2.2. Если у файла длина в байтах НЕ больше 50, то для всех таких файлов:
2.2.1. отсортировать их по имени файла в возрастающем порядке, путь не учитывать при сортировке
2.2.2. переименовать resultFileAbsolutePath в 'allFilesContent.txt'
2.2.3. в allFilesContent.txt последовательно записать содержимое всех файлов из п. 2.2.1. Тела файлов разделять "\n"
2.3. Удалить директории без файлов (пустые).
Все файлы имеют расширение txt.
*/
public class Solution {
    public static void main(String[] args) throws IOException {

        final LinkedList<Path> resultFiles = new LinkedList<>();

        Path start = Paths.get(args[0]);
        final Path result = Paths.get(args[1]);

        Files.walkFileTree(start, new FileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (Files.isSameFile(file, result)) return FileVisitResult.CONTINUE;
                if (Files.size(file) > 50) {
                    Files.delete(file);
                }
                else {
                    resultFiles.add(file);
                }
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                if (isDirEmpty(dir)) {
                    Files.delete(dir);
                }
                return FileVisitResult.CONTINUE;
            }
        });

        Collections.sort(resultFiles, new Comparator<Path>() {
            @Override
            public int compare(Path o1, Path o2) {
                return o1.getFileName().compareTo(o2.getFileName());
            }
        });

        Path resultnew = Files.move(result, result.resolveSibling("allFilesContent.txt"));

        OutputStream fos = Files.newOutputStream(resultnew);

        for (Path file : resultFiles) {
            if (Files.copy(file, fos)>0)
                fos.write("\n".getBytes());


        }
        fos.close();
    }

    private static boolean isDirEmpty(Path dir) {
        try {
            boolean isEmpty;
            DirectoryStream<Path> stream = Files.newDirectoryStream(dir);
            if (stream.iterator().hasNext()) {
                isEmpty = false;
            }
            else {
                isEmpty = true;
            }
            stream.close();
            return isEmpty;
        }
        catch (IOException e) {
            return false;
        }
    }
}
