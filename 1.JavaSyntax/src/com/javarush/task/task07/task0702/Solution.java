package com.javarush.task.task07.task0702;

import java.io.*;

class Cat
{
    public String name;
    public int age;
    public int weight;

    public void save(OutputStream outputStream) throws Exception
    {
        PrintWriter printWriter = new PrintWriter(outputStream);
        printWriter.println(name);
        printWriter.println(age);
        printWriter.println(weight);
        printWriter.flush();
    }

    public void load(InputStream inputStream) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        name = reader.readLine();
        age = Integer.parseInt(reader.readLine());
        weight = Integer.parseInt(reader.readLine());
    }

    public static void main(String[] args) {
        Cat cat1;
        int x =1;
        int y =1;
        String result = x == y ? null : "test";
    }
}