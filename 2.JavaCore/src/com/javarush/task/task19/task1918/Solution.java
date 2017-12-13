package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат.

Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span><span>Super</span><span>girl</span>

Первым параметром в метод main приходит тег. Например, "span".
Вывести на консоль все теги, которые соответствуют заданному тегу.
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле.
Количество пробелов, n, r не влияют на результат.
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нет.
Тег может содержать вложенные теги.

Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>
<span>Super</span>
<span>girl</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми


Требования:
1. Программа должна считывать имя файла с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое файла (используй FileReader).
4. Поток чтения из файла (FileReader) должен быть закрыт.
5. Программа должна выводить в консоль все теги, которые соответствуют тегу, заданному в параметре метода main.
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader a = new BufferedReader(new InputStreamReader(System.in));
        String f = a.readLine();
        a.close();
        BufferedReader b = new BufferedReader(new FileReader(f));
        String c = "";
        while (b.ready()) {
            c = c + b.readLine();
        }
        b.close();

        // Заменяем <span> на <span > чтобы не искать по подстроке. Потом вернем обратно
        c = c.replace("<" + args[0] + ">", "<" + args[0] + " >");
        // Сколько пар тегов в файле
        int count = 0;
        Pattern p = Pattern.compile("</" + args[0] + ">");
        Matcher m = p.matcher(c);
        while (m.find())
            count++;
        // Если открывающийся тег, заносим в мапу индекс тега со значением null.
        // Если закрывающийся тег, то ищем последний элемент мапы с null и пищем туда индекс тега
        Map<Integer, Integer> map = new TreeMap<>();
        int pos = -1;
        for (int i = 0; i < count * 2; i++) {
            int posTagBegin = c.indexOf("<" + args[0] + " ", pos + 1);
            int posTagEnd = c.indexOf("</" + args[0] + ">", pos + 1);
            if (posTagBegin >= 0 && posTagBegin < posTagEnd) {
                pos = posTagBegin;
                map.put(posTagBegin, null);
            } else {
                ArrayList<Integer> keys = new ArrayList<>(map.keySet());
                for (int j = keys.size() - 1; j >= 0; j--) {
                    if (map.get(keys.get(j)) == null) {
                        map.put(keys.get(j), posTagEnd);
                        break;
                    }
                }
                pos = posTagEnd;
            }
        }
        // Вывод
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(c.substring(entry.getKey(), entry.getValue() + args[0].length() +3).replace("<" + args[0] + " >", "<" + args[0] + ">"));
        }
    }
}