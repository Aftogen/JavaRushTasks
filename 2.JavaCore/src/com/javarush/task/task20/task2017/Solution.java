package com.javarush.task.task20.task2017;

import java.io.*;

/* 
Десериализация
На вход подается поток, в который записан сериализованный объект класса A либо класса B.
Десериализуй объект в методе getOriginalObject так, чтобы в случае возникновения исключения было выведено сообщение на экран и возвращен null.
Реализуй интерфейс Serializable где необходимо.


Требования:
1. Класс B должен быть потомком класса A.
2. Класс A должен поддерживать интерфейс Serializable.
3. Класс B не должен явно поддерживать интерфейс Serializable.
4. Метод getOriginalObject должен возвращать объект типа A полученный из потока ObjectInputStream.
5. Метод getOriginalObject должен возвращать null, если при попытке десериализации не был получен объект типа A. -
6. Метод getOriginalObject должен возвращать null, если при попытке десериализации возникло исключение. -

*/
public class Solution {
    public  A getOriginalObject(ObjectInputStream objectStream) {
        A result ;
        try {
            result = (A) objectStream.readObject();
        } catch (Exception e) {
            result = null;
        }
        return result;

    }

    public  class A implements Serializable {
    }

    public  class B extends A {
        public B() {
            System.out.println("inside B");
        }
    }

    public static void main(String[] args) throws IOException {
        /*A a = new A();
        B b = new B();

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:/task2017.dat"));
        oos.writeObject(a);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:/task2017.dat"));
        A result = getOriginalObject(ois);
        System.out.println(result.getClass());
        ois.close();

        ObjectOutputStream oos1 = new ObjectOutputStream(new FileOutputStream("D:/task2017B.dat"));
        oos1.writeObject(b);
        oos1.close();

        ObjectInputStream ois1 = new ObjectInputStream(new FileInputStream("D:/task2017B.dat"));
        A result1 = getOriginalObject(ois1);
        System.out.println(result1);
        ois1.close();*/


    }
}
