package com.javarush.task.task22.task2211;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

/* 
Смена кодировки
В метод main первым параметром приходит имя файла, тело которого в кодировке Windows-1251. Смотри файл example.txt для примера.
В метод main вторым параметром приходит имя файла, в который необходимо записать содержимое первого файла в кодировке UTF-8.
В результате во втором файле должен быть читабельный текст.


Требования:
1. Программа НЕ должна считывать данные с клавиатуры.
2. Программа НЕ должна выводить данные на экран.
3. Программа должна записывать данные в файл.
4. Содержимое второго файла должно соответствовать содержимому первого файла за исключением кодировки(UTF-8).
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        Charset UTF = Charset.forName("UTF-8");
        Charset windows1251 = Charset.forName("Windows-1251");


        //List<String> list = Files.readAllLines(Paths.get(args[0]),windows1251);
        //FileInputStream fis = new FileInputStream(args[0]);
        /*byte[] bytes = Files.readAllBytes(Paths.get("D:\\Downloads\\example.txt"));
        String s = new String(bytes,UTF);
        byte[] bytes2 = s.getBytes(windows1251);
        Path path = Paths.get("D:\\Downloads\\1.txt");
        Files.write(path, bytes2, StandardOpenOption.APPEND);
        */

        /*try(FileInputStream fis = new FileInputStream("D:\\Downloads\\example.txt");
            FileOutputStream fos = new FileOutputStream("D:\\Downloads\\1.txt");
        ){
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            String s = new String(buffer,windows1251);
            buffer = s.getBytes(UTF);
            fos.write(buffer);

            fos.write(new String(buffer, "UTF-8").getBytes("Windows-1251"));

        }*/



        FileInputStream fileInputStream = new FileInputStream("D:\\Downloads\\example.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\Downloads\\1.txt");

        byte[] buffer = new byte[fileInputStream.available()];
        fileInputStream.read(buffer);

        fileOutputStream.write(new String(buffer, "Windows-1251").getBytes("UTF-8"));

        fileInputStream.close();
        fileOutputStream.close();

    }
}
