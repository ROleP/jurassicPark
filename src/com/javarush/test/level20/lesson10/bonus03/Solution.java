package com.javarush.test.level20.lesson10.bonus03;

import java.util.ArrayList;
import java.util.List;

/* Кроссворд
1. Дан двумерный массив, который содержит буквы английского алфавита в нижнем регистре.
2. Метод detectAllWords должен найти все слова из words в массиве crossword.
3. Элемент(startX, startY) должен соответствовать первой букве слова, элемент(endX, endY) - последней.
text - это само слово, располагается между начальным и конечным элементами
4. Все слова есть в массиве.
5. Слова могут быть расположены горизонтально, вертикально и по диагонали как в нормальном, так и в обратном порядке.
6. Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        detectAllWords(crossword, "home", "same");
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {

        List<Word> wordsList = new ArrayList<>();
        for (String word : words) {
            wordsList.add(new Word(word));
        }

        int y = crossword.length;
        int x = crossword[0].length;

        int letter;
        for (String word : words) {
            letter = word.charAt(0);
            for (int i = 0; i < y; i++) {
                for (int j = 0; j < x; j++) {
                    if (crossword[i][j] == letter) {
                    }
                }
            }
        }

        List<String> lines = new ArrayList<>();

        for (int i = 0; i < y; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < x; j++) {
                sb.append(crossword[i][j]);
            }
            lines.add(sb.toString());
        }

        for (int i = 0; i < x; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < y; j++) {
                sb.append(crossword[i][j]);
            }
            lines.add(sb.toString());
        }





        return wordsList;
    }

    private void checkNearby(int x, int y) {
        for (int directionX = -1; directionX < 2; directionX++) {
            for (int directionY = -1; directionY < 2; directionY++) {
                //checkNext(x+directionX, y+directionY);
            }
        }
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
