package com.javarush.task.task20.task2010;

import java.io.Serializable;

/*
Как сериализовать что-то свое?
Сделайте так, чтобы сериализация класса Object была возможной.


Требования:
1. Класс Object должен существовать внутри класса Solution.
2. Класс Solution.Object должен быть статическим.
3. Класс Solution.Object должен быть публичным.
4. Класс Solution.Object должен поддерживать интерфейс Serializable.
5. Класс Solution.String должен поддерживать интерфейс Serializable.
*/
public class Solution {
    public static class Object implements Serializable{
        public String string1;
        public String string2;

        public Object() {
        }

        public Object(String string1, String string2) {
            this.string1 = string1;
            this.string2 = string2;
        }
    }

    public static int countStrings;

    public static class String implements Serializable{
        private final int number;

        public String() {
            number = ++countStrings;
        }

        public void print() {
            System.out.println("string #" + number);
        }

        private int readResolve(){
            return number;
        }

    }

    public static void main(String[] args) {

    }
}
