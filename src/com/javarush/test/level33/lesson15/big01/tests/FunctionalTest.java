package com.javarush.test.level33.lesson15.big01.tests;

import com.javarush.test.level33.lesson15.big01.Shortener;
import com.javarush.test.level33.lesson15.big01.strategies.*;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by rolep on 23/04/16.
 */
public class FunctionalTest {

    public void testStorage(Shortener shortener) {
        String one = "This is string one.";
        String two = "This is string two.";
        String three = "This is string one.";

        long idOne = shortener.getId(one);
        long idTwo = shortener.getId(two);
        long idThree = shortener.getId(three);

        Assert.assertNotEquals(idTwo, idOne);
        Assert.assertNotEquals(idTwo, idThree);
        Assert.assertEquals(idOne, idThree);

        String returnedOne = shortener.getString(idOne);
        String returnedTwo = shortener.getString(idTwo);
        String returnedThree = shortener.getString(idThree);

        Assert.assertEquals(returnedOne, one);
        Assert.assertEquals(returnedTwo, two);
        Assert.assertEquals(returnedThree, three);
    }

    @Test
    public void testHashMapStorageStrategy() {
        testStorage(new Shortener(new HashMapStorageStrategy()));
    }

    @Test
    public void testOurHashMapStorageStrategy() {
        testStorage(new Shortener(new OurHashMapStorageStrategy()));
    }

    @Test
    public void testFileStorageStrategy() {
        testStorage(new Shortener(new FileStorageStrategy()));
    }

    @Test
    public void testHashBiMapStorageStrategy() {
        testStorage(new Shortener(new HashBiMapStorageStrategy()));
    }

    @Test
    public void testDualHashBidiMapStorageStrategy() {
        testStorage(new Shortener(new DualHashBidiMapStorageStrategy()));
    }

    @Test
    public void testOurHashBiMapStorageStrategy() {
        testStorage(new Shortener(new OurHashBiMapStorageStrategy()));
    }
}
