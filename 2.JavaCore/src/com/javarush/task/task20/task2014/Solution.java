package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution

Подумай, какие поля не нужно сериализовать, пометь ненужные поля модификатором transient.
Объект всегда должен содержать актуальные итоговые данные.
Метод main не участвует в тестировании.

Написать код проверки самостоятельно в методе main:
1) создать файл, открыть поток на чтение (input stream) и на запись(output stream);
2) создать экземпляр класса Solution — savedObject;
3) записать в поток на запись savedObject (убедитесь, что они там действительно есть);
4) создать другой экземпляр класса Solution с другим параметром;
5) загрузить из потока на чтение объект — loadedObject;
6) проверить, что savedObject.string равна loadedObject.string;
7) обработать исключения.


Требования:
1. Поле pattern должно быть отмечено модификатором transient.
2. Поле currentDate должно быть отмечено модификатором transient.
3. Поле temperature должно быть отмечено модификатором transient.
4. Поле string НЕ должно быть отмечено модификатором transient.
*/
public class Solution implements Externalizable{
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        System.out.println(new Solution(4));

        Solution savedObject = new Solution(5);

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:/task2014.dat"));
        oos.writeObject(savedObject);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:/task2014.dat"));
        Solution otcRestored = (Solution) ois.readObject();
        ois.close();

        System.out.println(otcRestored);

    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(string);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        string = (String) in.readObject();
    }

    transient private  final String pattern = "dd MMMM yyyy, EEEE";
    transient private Date currentDate;
    transient private int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    public Solution(){

    }

    @Override
    public String toString() {
        return this.string;
    }
}
