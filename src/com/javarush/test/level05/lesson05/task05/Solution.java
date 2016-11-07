package com.javarush.test.level05.lesson05.task05;

/* Провести три боя  попарно между котами
Создать три кота используя класс Cat.
Провести три боя попарно между котами.
Класс Cat создавать не надо. Для боя использовать метод boolean fight(Cat anotherCat).
Результат каждого боя вывести на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        Cat cat1 = new Cat("Tom", 4, 7, 10);
        Cat cat2 = new Cat("Vaska", 7, 5, 12);
        Cat cat3 = new Cat("Murzik", 2, 10, 8);
        String r1 = cat1.fight(cat2) ? cat1.name : cat2.name;
        String r2 = cat2.fight(cat3) ? cat2.name : cat3.name;
        String r3 = cat1.fight(cat3) ? cat1.name : cat3.name;
        System.out.println(cat1.name + " дерется с " + cat2.name + ". Победитель: " + r1);
        System.out.println(cat2.name + " дерется с " + cat3.name + ". Победитель: " + r2);
        System.out.println(cat1.name + " дерется с " + cat3.name + ". Победитель: " + r3);
    }

    public static class Cat
    {

        public static int count = 0;
        public static int fightCount = 0;

        protected String name;
        protected int age;
        protected int weight;
        protected int strength;

        public Cat(String name, int age, int weight, int strength)
        {
            count++;

            this.name = name;
            this.age = age;
            this.weight = weight;
            this.strength = strength;
        }

        public boolean fight(Cat anotherCat)
        {
            fightCount++;

            int agePlus = this.age > anotherCat.age ? 1 : 0;
            int weightPlus = this.weight > anotherCat.weight ? 1 : 0;
            int strengthPlus = this.strength > anotherCat.strength ? 1 : 0;

            int score = agePlus + weightPlus + strengthPlus;
            return score > 2; // return score > 2 ? true : false;
        }
    }
}
