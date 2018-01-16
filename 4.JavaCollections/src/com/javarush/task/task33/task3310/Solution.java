package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        StorageStrategy strategy2 = new OurHashMapStorageStrategy();
        testStrategy(strategy2, 10000);
        StorageStrategy strategy3 = new FileStorageStrategy();
        testStrategy(strategy3, 100);
        StorageStrategy strategy4 = new OurHashBiMapStorageStrategy();
        testStrategy(strategy4, 10000);


    }

    /**
     * Этот метод должен для переданного множества строк возвращать множество идентификаторов.
     * Идентификатор для каждой отдельной строки нужно получить, используя shortener.
     */
    public static Set<Long> getIds(Shortener shortener, Set<String> strings) {
        Set<Long> result = new HashSet<>();
        for (String string : strings) {
            result.add(shortener.getId(string));
        }
        return result;
    }

    /**
     * Метод будет возвращать множество строк, которое соответствует переданному множеству идентификаторов.
     * При реальном использовании Shortener, задача получить из множества строк множество идентификаторов и
     * наоборот скорее всего не встретится, это нужно исключительно для тестирования.
     */
    public static Set<String> getStrings(Shortener shortener, Set<Long> keys) {
        Set<String> result = new HashSet<>();
        for (Long key : keys) {
            result.add(shortener.getString(key));
        }
        return result;
    }
    /*
    Метод будет тестировать работу переданной стратегии на определенном количестве элементов elementsNumber. Реализация метода должна:
    6.2.3.1. Выводить имя класса стратегии. Имя не должно включать имя пакета.
    6.2.3.2. Генерировать тестовое множество строк, используя Helper и заданное количество элементов elementsNumber.
    6.2.3.3. Создавать объект типа Shortener, используя переданную стратегию
    6.2.3.4. Замерять и выводить время необходимое для отработки метода getIds для заданной стратегии и заданного множества элементов.
    Время вывести в миллисекундах. При замере времени работы метода можно пренебречь переключением процессора на другие потоки, временем,
    которое тратится на сам вызов, возврат значений и вызов методов получения времени (даты). Замер времени произведи с использованием объектов типа Date.
    6.2.3.5. Замерять и выводить время необходимое для отработки метода getStrings для заданной стратегии и полученного в предыдущем пункте множества идентификаторов.
    6.2.3.6. Сравнивать одинаковое ли содержимое множества строк, которое было сгенерировано и множества, которое было возвращено методом getStrings.
    Если множества одинаковы, то выведи "Тест пройден.", иначе "Тест не пройден.".
    6.2.4. Добавь метод main(). Внутри метода протестируй стратегию HashMapStorageStrategy с помощью 10000 элементов.
    6.3. Проверь, что программа работает и тест пройден.*/


    public static void testStrategy(StorageStrategy strategy, long elementsNumber) {
        Helper.printMessage(strategy.getClass().getSimpleName());
        HashSet<String> strings = new HashSet<>();

        for (int i = 0; i < elementsNumber; i++)
            strings.add(Helper.generateRandomString());

        Shortener shortener = new Shortener(strategy);

        //6.2.3.4. Замерять и выводить время необходимое для отработки метода getIds для заданной стратегии
        Date startDateTime = new Date();
        Set<Long> ids = getIds(shortener, strings);
        Date finishDateTime = new Date();

        long deltaTime = finishDateTime.getTime() - startDateTime.getTime();
        Helper.printMessage(Long.toString(deltaTime));

        //6.2.3.5. Замерять и выводить время необходимое для отработки метода getStrings для заданной стратегии
        startDateTime = new Date();
        Set<String> strs = getStrings(shortener, ids);
        finishDateTime = new Date();

        deltaTime = finishDateTime.getTime() - startDateTime.getTime();
        Helper.printMessage(Long.toString(deltaTime));


        //6.2.3.6. Сравнивать одинаковое ли содержимое множества строк, которое было сгенерировано и множества, которое было возвращено методом getStrings.
        if (strings.equals(strs))
            Helper.printMessage("Тест пройден.");
        else
            Helper.printMessage("Тест не пройден.");
    }


}
