package com.javarush.task.task20.task2005;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Очень странные дела
При чтении/записи объектов типа Human возникают странные ошибки.
Разберись в чем дело и исправь их.


Требования:
1. Логика чтения/записи реализованная в методах save/load должна работать корректно в случае, если список assets равен null.
2. Логика чтения/записи реализованная в методах save/load должна работать корректно в случае, если поле name и список assets не равны null.
3. Класс Solution.Human не должен поддерживать интерфейс Serializable.
4. Класс Solution.Human должен быть публичным.
5. Класс Solution.Human не должен поддерживать интерфейс Externalizable.
6. Метод equals должен возвращать true для двух равных объектов типа Human и false для разных.
7. Метод hashCode должен всегда возвращать одно и то же значение для одного и того же объекта типа Human.
*/

public class Solution {
    public static void main(String[] args) {
        //исправь outputStream/inputStream в соответствии с путем к твоему реальному файлу
        try {
            File file1 = File.createTempFile("C:\\Users\\Igor\\Desktop\\data1.txt", null);
            OutputStream outputStream = new FileOutputStream(file1);
            InputStream inputStream = new FileInputStream(file1);

            //Human ivanov = new Human("Ivanov", new Asset("home"), new Asset("car"));
            Human ivanov = new Human();
            ivanov.save(outputStream);
            outputStream.flush();
            outputStream.close();

            Human somePerson = new Human();
            somePerson.load(inputStream);

            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны
            System.out.println(ivanov.equals(somePerson));
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Human human = (Human) o;

            if (name == null ? human.name != null : !name.equals(human.name)) return false;
            return assets != null ? assets.equals(human.assets) : human.assets == null;

        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            return result;
        }

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter printWriter = new PrintWriter(outputStream);
            if(this.name != null) {
                printWriter.println("yes");
                printWriter.println(this.name);
                printWriter.println(assets.size());

                if (this.assets.size() > 0) {
                    for (Asset current : this.assets) {
                        printWriter.println(current.getName());
                        printWriter.println(current.getPrice());
                    }
                }
            }
            else if(this.name == null)
                printWriter.println("no");
            printWriter.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String name1= reader.readLine();
            if(name1.equals("yes")){
                this.name = reader.readLine();
                int i=Integer.parseInt(reader.readLine());
                while((i--)>0) {
                    Asset asset = new Asset(reader.readLine());
                    asset.setPrice(Double.parseDouble(reader.readLine()));
                    this.assets.add(asset);
                }
            }
            else if(name1.equals("no"))
                this.name = null;
            reader.close();
        }
    }
}