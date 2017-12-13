package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/* 
Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Использовать StringBuilder.

Пример содержимого файла
рот тор торт о
о тот тот тот

Вывод:
рот тор
о о
тот тот


Требования:
1. Метод main должен считывать имя файла с клавиатуры.
2. В методе main должен быть использован StringBuilder
3. Список result должен быть заполнен корректными парами согласно условию задачи.
4. В классе Solution должен содержаться вложенный класс Pair.
5. В классе Pair должен быть объявлен конструктор без параметров (или конструктор по умолчанию).
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();
        br.close();
        StringBuilder temp = new StringBuilder();
        String s;
        List<String> list = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        BufferedReader br1 = new BufferedReader(new FileReader(name));
        while ((s = br1.readLine()) != null) {
            //E:\test.txt
            list.add(s);
            System.out.println(s);
        }
        br1.close();

        for (int i = 0; i < list.size(); i++)
        {
            temp.append(list.get(i));
            temp.append(" ");
        }
        System.out.println(temp);

        Collections.addAll(list1, temp.toString().split("\\s"));

        for (int i = 0; i < list1.size(); i++)
            for (int j = i+1; j < list1.size(); j++) {
                String x1 = list1.get(i);
                String x2 = new StringBuilder(list1.get(j)).reverse().toString();
                if (x1.equals(x2)) {
                    Pair pair = new Pair();
                    pair.first = x1;
                    pair.second = new StringBuilder(x2).reverse().toString();
                    if (!result.contains(pair))
                        result.add(pair);
                }
            }

        for (Pair x : result)
            System.out.println(x);
    }

    public static class Pair {
        String first;
        String second;

        public Pair() {}

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                            second == null && first != null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;
        }
    }
}