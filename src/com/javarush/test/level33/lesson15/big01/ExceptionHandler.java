package com.javarush.test.level33.lesson15.big01;

/**
 * Created by rolep on 4/19/16.
 */
public class ExceptionHandler {

    public static void log(Exception e) {
        Helper.printMessage(e.getMessage());
    }
}
