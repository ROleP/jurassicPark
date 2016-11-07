package com.javarush.test.level20.lesson10.bonus01;

import java.util.ArrayList;

/* Алгоритмы-числа
Число S состоит из M чисел, например, S=370 и M(количество цифр)=3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.
*/
public class Solution {
    public static int[] getNumbers(int N) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (int i = 1; i < N; i++) {
            int s = 0,
                    k = i,
                    n = 0;
            while (k != 0) {
                k = k / 10;
                n++;
            }
            k = i;
            while (k != 0) {
                int p = k % 10;
                k = k / 10;
                if (p != 0) {
                    int buf = 1;
                    for (int g = 0; g < n; g++)
                        buf = buf*p;
                    s = s + buf;
                }
            }
            if (s == i) {
                arrayList.add(i);
            }
        }
        int[] result = new int[arrayList.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = arrayList.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        getNumbers(5);
    }
}
