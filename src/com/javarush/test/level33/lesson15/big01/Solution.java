package com.javarush.test.level33.lesson15.big01;

import com.javarush.test.level33.lesson15.big01.strategies.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by rolep on 4/19/16.
 */
public class Solution {

    public static void main(String[] args) {
        testStrategy(new HashMapStorageStrategy(), 10000);
        testStrategy(new OurHashMapStorageStrategy(), 10000);
        testStrategy(new FileStorageStrategy(), 10000);
        testStrategy(new OurHashBiMapStorageStrategy(), 10000);
        testStrategy(new HashBiMapStorageStrategy(), 10000);
        testStrategy(new DualHashBidiMapStorageStrategy(), 10000);
    }

    public static Set<Long> getIds(Shortener shortener, Set<String> strings) {
        Set<Long> ids = new HashSet<>();
        for (String s : strings) {
            ids.add(shortener.getId(s));
        }
        return ids;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys) {
        Set<String> strings = new HashSet<>();
        for (Long key : keys) {
            strings.add(shortener.getString(key));
        }
        return strings;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber) {
        Helper.printMessage(strategy.getClass().getSimpleName());
        Set<String> strings = new HashSet<>();
        for (long i = 0; i < elementsNumber; i++) {
            strings.add(Helper.generateRandomString());
        }
        Shortener shortener = new Shortener(strategy);

        long getIdsStart = new Date().getTime();
        Set<Long> testIds = getIds(shortener, strings);
        long getIdsEnd = new Date().getTime();

        Helper.printMessage("Time of getIds request for " + elementsNumber + " elements: " + (getIdsEnd-getIdsStart) + " ms");

        long getStringsStart = new Date().getTime();
        Set<String> testStrings = getStrings(shortener, testIds);
        long getStringsEnd = new Date().getTime();

        Helper.printMessage("Time of getStrings request for " + elementsNumber + " elements: " + (getStringsEnd-getStringsStart) + " ms");

        if (strings.size() == testStrings.size() && testStrings.containsAll(strings)) {
            Helper.printMessage("Тест пройден.");
        }
        else {
            Helper.printMessage("Тест не пройден.");
        }
    }
}
