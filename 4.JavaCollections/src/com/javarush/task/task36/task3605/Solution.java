package com.javarush.task.task36.task3605;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* 
Использование TreeSet
Первым параметром приходит имя файла: файл1.
файл1 содержит только буквы латинского алфавита, пробелы, знаки препинания, тире, символы перевода каретки.
Отсортируй буквы по алфавиту и выведи на экран первые 5 различных букв в одну строку без разделителей.
Если файл1 содержит менее 5 различных букв, то выведи их все.
Буквы различного регистра считаются одинаковыми.
Регистр выводимых букв не влияет на результат.
Закрой потоки.

Пример 1 данных входного файла:
zBk yaz b-kN

Пример 1 вывода:
abkny

Пример 2 данных входного файла:
caAC
A, aB? bB

Пример 2 вывода:
abc

Подсказка: использовать TreeSet


Требования:
1. Программа должна использовать класс TreeSet.
2. У объекта типа TreeSet вызови метод add для добавления элементов.
3. Программа должна выводить результат на экран.
4. Вывод программы должен соответствовать условию задачи.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
            //Reading all lines from file
            StringBuilder sb = new StringBuilder();
            String line = reader.readLine();
            sb.append(line);
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            String content = sb.toString();
            //Converting lines to char[] chars with no upperCase and marks
            char[] chars = content.toLowerCase().replaceAll("[^\\p{Alpha}]", "").toCharArray();
            //Creating treeSet of chars
            TreeSet<Character> treeSet = new TreeSet<>();
            for (char aChar : chars) {
                treeSet.add(aChar);
            }
            //Print five first chars to console
            Iterator<Character> iterator = treeSet.iterator();
            int size = treeSet.size() < 5 ? treeSet.size() : 5; //max 5 chars
            for (int i = 0; i < size; i++) {
                System.out.print(iterator.next());
            }
        }
    }
}
