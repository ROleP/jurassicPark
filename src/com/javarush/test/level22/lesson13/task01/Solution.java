package com.javarush.test.level22.lesson13.task01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/* StringTokenizer
Используя StringTokenizer разделить query на части по разделителю delimiter.
Пример,
getTokens("level22.lesson13.task01", ".") == {"level22", "lesson13", "task01"}
*/
public class Solution {
    public static String [] getTokens(String query, String delimiter) {
        ArrayList<String> tokens = new ArrayList<String>();
        StringTokenizer st = new StringTokenizer(query, delimiter);
        while (st.hasMoreTokens())
            tokens.add(st.nextToken());
        String[] result = new String[tokens.size()];
        tokens.toArray(result);
        return result;
    }
}
