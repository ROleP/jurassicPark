package com.javarush.test.level33.lesson15.big01.strategies;

import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created by rolep on 21/04/16.
 */
public class FileBucket {

    private Path path;

    public FileBucket() {
        path = null;
        try {
            path = Files.createTempFile(null, null);
        }
        catch (Exception e) {

        }
        new File(path.toAbsolutePath().toString()).deleteOnExit();
    }

    public long getFileSize() {
        long fileSize = 0l;
        try {
            fileSize = Files.size(path);
        }
        catch (Exception e) {

        }
        return fileSize;
    }

    public void putEntry(Entry entry) {
        try (ObjectOutputStream os = new ObjectOutputStream(Files.newOutputStream(path))) {
        os.writeObject(entry);
        }
        catch (Exception e) {

        }
    }

    public Entry getEntry() {
        Entry entry = null;
        try (ObjectInputStream is = new ObjectInputStream(Files.newInputStream(path))) {
        entry = (Entry) is.readObject();
        }
        catch (Exception e) {

        }
        return entry;
    }

    public void remove() {
        try {
            Files.delete(path);
        }
        catch (Exception e) {

        }
    }
}
