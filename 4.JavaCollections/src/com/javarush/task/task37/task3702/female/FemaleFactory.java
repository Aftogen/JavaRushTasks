package com.javarush.task.task37.task3702.female;


import com.javarush.task.task37.task3702.AbstractFactory;
import com.javarush.task.task37.task3702.Human;


public class FemaleFactory implements AbstractFactory {
    public Human getPerson(int age){
        Human human = null;
        if (age<=KidGirl.MAX_AGE ) {
            human = new KidGirl();
        }
        if (age>KidGirl.MAX_AGE && age<=TeenGirl.MAX_AGE ){
            human = new TeenGirl();
        }

        if (age>TeenGirl.MAX_AGE ){
            human = new Woman();
        }
        return human;
    }
}
