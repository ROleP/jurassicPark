package com.javarush.test.level21.lesson08.task03;

/* Запретить клонирование
Разрешите клонировать класс А
Запретите клонировать класс B
Разрешите клонировать класс C
*/
public class Solution {

/*
    public static void main(String[] args) throws Exception
    {
        A a = new A(1,2);
        a.clone();
        System.out.println(a);
        B b = new B(2,3,"qwe");
        b.clone();
        System.out.println(b);
        C c = new C(3,4,"ewr");
        c.clone();
        System.out.println(c);
    }
*/
    public static class A implements Cloneable {
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }

        protected A clone() throws CloneNotSupportedException
        {
            if (!this.getClass().getSimpleName().equals("A")) throw new CloneNotSupportedException();
            return new A(getI(), getJ());
        }
    }

    public static class B extends A {
        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static class C extends B implements Cloneable {
        public C(int i, int j, String name) {
            super(i, j, name);
        }
        protected C clone()
        {
            return new C(super.getI(),super.getJ(),super.getName());
        }
    }
}
