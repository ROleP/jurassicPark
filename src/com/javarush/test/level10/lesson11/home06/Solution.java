package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        //напишите тут ваши переменные и конструкторы
        String name;
        int age;
        boolean sex;
        int height;
        int weight;
        Human parent;

        public Human()
        {
            this.name = "Ololo";
        }

        public Human(String name)
        {
            this.name = name;
        }

        public Human(int age)
        {
            this.age = age;
        }

        public Human(String name, int age)
        {
            this.name = name;
            this.age = age;
        }

        public Human(boolean sex)
        {
            this.sex = sex;
        }

        public Human(String name, boolean sex)
        {
            this.name = name;
            this.sex = sex;
        }

        public Human(String name, int age, boolean sex)
        {
            this.name = name;
            this.age = age;
            this.sex = sex;
        }

        public Human(String name, int age, int height, int weight)
        {
            this.name = name;
            this.age = age;
            this.height = height;
            this.weight = weight;
        }

        public Human(String name, int age, int height)
        {
            this.name = name;
            this.age = age;
            this.height = height;
        }

        public Human(String name, Human parent)
        {
            this.name = name;
            this.parent = parent;
        }
    }
}
