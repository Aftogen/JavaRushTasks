package com.javarush.task.task36.task3601;

public class View {
    public void fireEventShowData() {
        System.out.println(new Controller().onDataListShow());
    }
}
