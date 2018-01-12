package com.javarush.task.task36.task3607;


import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;
import java.util.concurrent.DelayQueue;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/*
Найти класс по описанию
Описание класса:
1. Реализует интерфейс Queue.
2. Используется при работе с трэдами.
3. Из этой очереди элементы могут быть взяты только тогда, когда они заэкспарятся, их время задержки истекло.
4. Головой очереди является элемент, который заэкспарился раньше всех.

Требования:
1. Метод getExpectedClass не должен использовать метод getDeclaredClasses.
2. Метод getExpectedClass должен вернуть правильный тип.
3. Метод main должен вызывать метод getExpectedClass.
4. Метод main должен вывести полученный класс на экран.
*/
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
/*
Найти класс по описанию
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getExpectedClass());
    }


    //DelayQueue.class;
    public static Class getExpectedClass() {
        return DelayQueue.class; //hack
    }
}