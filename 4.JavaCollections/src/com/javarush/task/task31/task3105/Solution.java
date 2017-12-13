package com.javarush.task.task31.task3105;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив

В метод main приходит список аргументов.
Первый аргумент - полный путь к файлу fileName.
Второй аргумент - путь к zip-архиву.
Добавить файл (fileName) внутрь архива в директорию 'new'.
Если в архиве есть файл с таким именем, то заменить его.

Пример входных данных:
C:/result.mp3
C:/pathToTest/test.zip

Файлы внутри test.zip:
a.txt
b.txt

После запуска Solution.main архив test.zip должен иметь такое содержимое:
new/result.mp3
a.txt
b.txt

Подсказка: нужно сначала куда-то сохранить содержимое всех энтри, а потом записать в архив все энтри вместе с добавленным файлом.
Пользоваться файловой системой нельзя.


Требования:
1. В методе main создай ZipInputStream для архивного файла (второй аргумент main). Нужно вычитать из него все содержимое.
2. В методе main создай ZipOutputStream для архивного файла (второй аргумент main).
3. В ZipOutputStream нужно записать содержимое файла, который приходит первым аргументом в main.
4. В ZipOutputStream нужно записать все остальное содержимое, которое было вычитано из ZipInputStream.
5. Потоки для работы с архивом должны быть закрыты.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = args[0];
        String zipFile = args[1];
        Map<ZipEntry, StringBuffer> map = new HashMap<>();
        try(ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFile));){
            ZipEntry entry;
            int i;
            while ((entry = zis.getNextEntry()) != null) {
                StringBuffer sb = new StringBuffer();
                while ((i = zis.read()) != -1) {
                    sb.append((char) i);
                }
                map.put(entry, sb);
            }
            File file = new File(fileName);
            try(ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipFile));){
                zos.putNextEntry(new ZipEntry("new/" + file.getName()));
                Files.copy(file.toPath(), zos);
                for (Map.Entry<ZipEntry, StringBuffer> pair : map.entrySet()) {
                    if (!pair.getKey().getName().equals(file.getName())) {
                        zos.putNextEntry(pair.getKey());
                        for (char c : pair.getValue().toString().toCharArray()) {
                            zos.write(c);
                        }
                    } else {
                        zos.putNextEntry(new ZipEntry(pair.getKey().getName()));
                        Files.copy(file.toPath(), zos);
                    }
                }
                zis.close();
                zos.close();
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }



    }
}
