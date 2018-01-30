package com.javarush.task.task38.task3803;

/* 
Runtime исключения (unchecked exception)
*/

import java.util.ArrayList;

public class VeryComplexClass {
    public void methodThrowsClassCastException() {
        Object bool = new Boolean(true);
        System.out.println((String)bool);
    }

    public void methodThrowsNullPointerException() {
        ArrayList<Object> list = null;
        list.size();

    }

    public static void main(String[] args) {
    }
}
