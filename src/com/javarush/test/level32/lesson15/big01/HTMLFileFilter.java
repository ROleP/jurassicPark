package com.javarush.test.level32.lesson15.big01;

import javax.swing.filechooser.FileFilter;
import java.io.File;

/**
 * Created by rolep on 17/04/16.
 */
public class HTMLFileFilter extends FileFilter {

    @Override
    public boolean accept(File f) {
        if (f.isDirectory()) {
            return true;
        }

        String s = f.getName();

        if (s == null) {
            return false;
        }

        s = s.toLowerCase();
        if (s.endsWith(".html") || s.endsWith(".htm")) {
            return true;
        }

        return false;

    }

    @Override
    public String getDescription() {
        return "HTML и HTM файлы";
    }
}
