package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;
/*Давай реализуем настраиваемый поиск файлов в директории.
Просмотри интерфейс java.nio.file.FileVisitor и его базовую реализацию java.nio.file.SimpleFileVisitor.
Во время поиска по дереву файлов с помощью метода Files.walkFileTree(Path start, FileVisitor<? super Path> visitor)
мы используем объект FileVisitor для выполнения необходимых операций над найденными объектами и.

Наш класс для поиска будет называться SearchFileVisitor и расширять SimpleFileVisitor.

Поиск можно будет выполнять по таким критериям:
— выражение, встречающееся в названии файла (String);
— выражение, встречающееся в содержимом файла (String);
— максимальный и минимальный размер файла (int).
Можно задавать либо один, либо сразу несколько критериев для поиска.

Я в main написал код, который использует готовый SearchFileVisitor для поиска файлов, тебе осталась совсем легкая задача — выполнить его реализацию.
Подсказка 1: методы get… , set… — это геттеры и сеттеры полей. Основная логика класса по поиску выполняется в методе visitFile(Path file, BasicFileAttributes attrs).
Подсказка 2: для работы с файлами используй только классы из пакета java.nio.


Требования:
1. В классе SearchFileVisitor нужно создать поля partOfName, partOfContent, minSize, maxSize и сеттеры для них. +
2. В классе SearchFileVisitor нужно создать поле foundFiles и геттер для него. Поле должно быть сразу инициализировано. +
3. Если в SearchFileVisitor задан критерий поиска partOfName, метод visitFile должен добавить файл в foundFiles, если в названии содержится строка partOfName.
4. Если в SearchFileVisitor задан критерий поиска partOfContent, метод visitFile должен добавить файл в foundFiles, если в содержимом встречается строка partOfContent.
5. Если в SearchFileVisitor задан критерий поиска maxSize, метод visitFile должен добавить файл в foundFiles, если размер файла меньше maxSize.
6. Если в SearchFileVisitor задан критерий поиска minSize, метод visitFile должен добавить файл в foundFiles, если размер файла больше minSize.
7. Метод visitFile должен быть реализован так, чтобы учитывать сразу несколько критериев поиска.*/


public class SearchFileVisitor extends SimpleFileVisitor<Path> {

    private String partOfName="", partOfContent="";
    private int minSize=0, maxSize=Integer.MAX_VALUE;
    private List<Path> foundFiles = new ArrayList<Path>();

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public List<Path> getFoundFiles() {
        return foundFiles;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        byte[] content = Files.readAllBytes(file); // размер файла: content.length
        long fileSize = Files.size(file);
        String buff = new String(Files.readAllBytes(file));
        if((minSize == 0 || fileSize>=minSize) && (maxSize == 0 || fileSize<=maxSize)){
            if(file.getFileName().toString().contains(partOfName)|| partOfName == null){
                if(partOfContent == null)
                    foundFiles.add(file);
                else if( buff.contains(partOfContent))
                    foundFiles.add(file);
            }
        }
        return super.visitFile(file, attrs);



        /*String temp = new String(content);
        //Считаю кол-во критериев:
        int criterionCount=0;
        if (!partOfName.equals("")) { criterionCount++; }
        if (!partOfContent.equals("")) { criterionCount++; }
        if (maxSize!=Integer.MAX_VALUE) { criterionCount++; }
        if (minSize!=0) { criterionCount++; }
        //Считаю кол-во совпадений по критериям:
        int matchCount=0;
        if (!partOfName.equals("") & file.toFile().getName().contains(partOfName)) { matchCount++;}
        if (!partOfContent.equals("") & temp.contains(partOfContent)){ matchCount++;}
        if (maxSize!=Integer.MAX_VALUE & content.length < maxSize){ matchCount++;}
        if (minSize!=0 & content.length > minSize){ matchCount++;}
        // При равенстве количества критериев и коливества совпадений по критериям добавляю файл
        if (matchCount==criterionCount)   foundFiles.add(file);*/

    }
}
