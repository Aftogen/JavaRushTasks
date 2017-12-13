package com.javarush.task.task05.task0512;

/* 
Создать класс (Circle) круг, с тремя инициализаторами:
— centerX, centerY, radius
— centerX, centerY, radius, width
— centerX, centerY, radius, width, color


Требования:
1. Программа не должна считывать данные с клавиатуры.
2. У класса Circle должны быть переменные centerX, centerY, radius, width и color с типом int.
3. У класса должен быть метод initialize, принимающий в качестве параметров centerX, centerY, radius и инициализирующий соответствующие переменные класса.
4. У класса должен быть метод initialize, принимающий в качестве параметров centerX, centerY, radius, width и инициализирующий соответствующие переменные класса.
5. У класса должен быть метод initialize, принимающий в качестве параметров centerX, centerY, radius, width, color и инициализирующий соответствующие переменные класса.
*/

public class Circle {

    int centerX, centerY, radius, width, color;

    public Circle(int centerX, int centerY, int radius) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
    }

    public Circle(int centerX, int centerY, int radius, int width) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
        this.width = width;
    }

    public Circle(int centerX, int centerY, int radius, int width, int color) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
        this.width = width;
        this.color = color;
    }

    public static void main(String[] args) {

    }
}
