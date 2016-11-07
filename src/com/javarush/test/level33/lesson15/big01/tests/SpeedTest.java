package com.javarush.test.level33.lesson15.big01.tests;

import com.javarush.test.level33.lesson15.big01.Helper;
import com.javarush.test.level33.lesson15.big01.Shortener;
import com.javarush.test.level33.lesson15.big01.strategies.HashBiMapStorageStrategy;
import com.javarush.test.level33.lesson15.big01.strategies.HashMapStorageStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by rolep on 23/04/16.
 */
public class SpeedTest {

    public long getTimeForGettingIds(Shortener shortener, Set<String> strings, Set<Long> ids) {

        long result = 0;
        for (String string : strings) {
            long time1 = new Date().getTime();
            ids.add(shortener.getId(string));
            long time2 = new Date().getTime();
            long duration = time2 - time1;
            result += duration;
        }
        return result;

        /*
        long start = new Date().getTime();
        for (String string : strings) {
            ids.add(shortener.getId(string));
        }
        long end = new Date().getTime();
        return end-start;
        */
    }

    public long getTimeForGettingStrings(Shortener shortener, Set<Long> ids, Set<String> strings) {

        long result = 0;
        for (Long id : ids) {
            long time1 = new Date().getTime();
            strings.add(shortener.getString(id));
            long time2 = new Date().getTime();
            long duration = time2 - time1;
            result += duration;
        }
        return result;

        /*
        long start = new Date().getTime();
        for (Long id : ids) {
            strings.add(shortener.getString(id));
        }
        long end = new Date().getTime();
        return end-start;
        */
    }

    @Test
    public void testHashMapStorage() {

        /*
        Shortener shortener1 = new Shortener(new HashMapStorageStrategy());
        Shortener shortener2 = new Shortener(new HashBiMapStorageStrategy());

        Set<String> origStrings = new HashSet<>();
        while (origStrings.size() < 10000) {
            origStrings.add(Helper.generateRandomString());
        }

        Set<Long> origIds = new HashSet<>();
        for (long i = 0l; i < 10000; i++) {
            origIds.add(i);
        }

        long s1IdsGetTime = getTimeForGettingIds(shortener1, origStrings, new HashSet<Long>());
        long s2IdsGetTime = getTimeForGettingIds(shortener2, origStrings, new HashSet<Long>());
        Assert.assertTrue(s1IdsGetTime > s2IdsGetTime);

        long s1StringsGetTime = getTimeForGettingStrings(shortener1, origIds, origStrings);
        long s2StringsGetTime = getTimeForGettingStrings(shortener2, origIds, origStrings);
        Assert.assertEquals(s1StringsGetTime, s2StringsGetTime, 5);
        */


        Shortener shortener1 = new Shortener(new HashMapStorageStrategy());
        Shortener shortener2 = new Shortener(new HashBiMapStorageStrategy());
        Set<String>origStrings = new HashSet<>();
        Set<Long>ids = new HashSet<>();
        for (long i = 0; i < 10000; i++) {
            ids.add(i);
        }
        for (int i = 0; i < ids.size(); i++) {
            origStrings.add(Helper.generateRandomString());
        }
        long time1 = getTimeForGettingIds(shortener1, origStrings, ids);
        long time2 = getTimeForGettingIds(shortener2, origStrings, ids);
        Assert.assertTrue(time1 > time2);
        long time3 = getTimeForGettingStrings(shortener1, ids, origStrings);
        long time4 = getTimeForGettingStrings(shortener2, ids, origStrings);
        Assert.assertEquals(time3, time4, 5);

    }
}
