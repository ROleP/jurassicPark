package com.javarush.test.level33.lesson15.big01;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * Created by rolep on 4/19/16.
 */
public class Helper {

    public static String generateRandomString() {
        return new BigInteger(130, new SecureRandom()).toString();
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }
}
