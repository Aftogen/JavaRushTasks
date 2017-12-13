package com.javarush.task.task05.task0525;

/* 
И целой утки мало
По аналогии с классом Duck (утка) создай классы Cat (кошка) и Dog (собака).
Подумай, что должен возвращать метод toString в классах Cat и Dog?
В методе main создай по два объекта каждого класса и выведи их на экран.
Объекты класса Duck уже созданы и выводятся на экран.


Требования:
1. Создай класс Cat(кошка).
2. Создай класс Dog(собака).
3. У класса Cat должен быть верно реализован метод toString.
4. У класса Dog должен быть верно реализован метод toString.
5. В методе main создай два объекта типа Cat.
6. В методе main создай два объекта типа Dog.
7. Выведи все созданные объекты на экран.
*/

public class Solution {

    public static void main(String[] args) {
        Duck duck1 = new Duck();
        Duck duck2 = new Duck();
        System.out.println(duck1);
        System.out.println(duck2);
        Cat cat1 = new Cat();
        Cat cat2 = new Cat();
        Dog dog1 = new Dog();
        Dog dog2 = new Dog();
    }

    public static class Duck {
        public String toString() {
            return "Duck";
        }
    }

    public static class Cat {
        @Override
        public String toString() {
            return "Cat";
        }
    }
    public static class Dog {
        @Override
        public String toString() {
            return "Dog";
        }
    }

}
