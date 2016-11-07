package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import com.javarush.test.level06.lesson08.task05.StringHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        Human ch1 = new Human("Child1", true, 7, new Human[]{});
        Human ch2 = new Human("Child2", true, 6, new Human[]{});
        Human ch3 = new Human("Child2", false, 5, new Human[]{});
        Human dad = new Human("Dad", true, 36, new Human[]{ch1, ch2, ch3});
        Human mom = new Human("Mom", false, 29, new Human[]{ch1, ch2, ch3});
        Human gd1 = new Human("GDad1", true, 64, new Human[]{dad});
        Human gd2 = new Human("GDad2", true, 75, new Human[]{mom});
        Human gm1 = new Human("GMom1", false, 61, new Human[]{dad});
        Human gm2 = new Human("GMom2", false, 68, new Human[]{mom});

        System.out.println(ch1);
        System.out.println(ch2);
        System.out.println(ch3);
        System.out.println(dad);
        System.out.println(mom);
        System.out.println(gd1);
        System.out.println(gd2);
        System.out.println(gm1);
        System.out.println(gm2);

    }

    public static class Human
    {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children;


        private Human(String name, boolean sex, int age, Human[] children)
        {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.children = new ArrayList<Human>();
            Collections.addAll(this.children, children);

        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }

            return text;
        }
    }

}
