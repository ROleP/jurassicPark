package com.javarush.test.level23.lesson04.task01;

/* Inner
Реализовать метод getTwoSolutions, который должен возвращать массив из 2-х экземпляров класса Solution.
Для каждого экземпляра класса Solution инициализировать поле innerClasses двумя значениями.
Инициализация всех данных должна происходить только в методе getTwoSolutions.
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        Solution[] sols = new Solution[2];
        sols[0] = new Solution();
        sols[1] = new Solution();
        sols[0].innerClasses[0] = sols[0].new InnerClass();
        sols[0].innerClasses[1] = sols[0].new InnerClass();
        sols[1].innerClasses[0] = sols[1].new InnerClass();
        sols[1].innerClasses[1] = sols[1].new InnerClass();
        return sols;
    }
}
