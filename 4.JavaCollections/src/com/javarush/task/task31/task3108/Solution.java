package com.javarush.task.task31.task3108;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/* 
Исследуем Path
Почитай про все методы класса Path.
Найди такой, который создает относительный путь между текущим и переданным путем.
Реализуй логику метода getDiffBetweenTwoPaths, он должен возвращать относительный путь.
Метод main не участвует в тестировании.


Требования:
1. Класс Solution должен содержать метод Path getDiffBetweenTwoPaths(Path path1, Path path2).
2. Метод Path getDiffBetweenTwoPaths(Path path1, Path path2) должен быть статическим.
3. Метод getDiffBetweenTwoPaths должен возвращать относительный путь между первым аргументом и вторым.
4. Для реализации метода getDiffBetweenTwoPaths используй правильный метод объекта Path.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        Path path1 = Paths.get("D:/test/data/firstDir");
        Path path2 = Paths.get("D:/test/data/secondDir/third");
        Path resultPath = getDiffBetweenTwoPaths(path1, path2);
        System.out.println(resultPath);   //expected output '../secondDir/third' or '..\secondDir\third'
    }

    public static Path getDiffBetweenTwoPaths(Path path1, Path path2) {
        return null;
    }
}
