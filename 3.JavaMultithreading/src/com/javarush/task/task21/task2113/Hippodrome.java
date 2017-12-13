package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Hippodrome {
    static private List<Horse> horses = new ArrayList<>();
    static Hippodrome game;

    Hippodrome(List<Horse> list) {
        this.horses = list;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void run() throws InterruptedException{
        for (int i = 0 ; i<100;i++){
            move();
            print();
            Thread.sleep(200);
        }
    }
    public void move(){
        for (Horse horse : horses){
            horse.move();
        }
    }
    public void print(){
        for (Horse horse : horses){
            horse.print();
        }
        for (int i = 0 ; i<10;i++){
            System.out.println();
        }
    }
    public Horse getWinner(){
        horses.sort(Comparator.comparingDouble(Horse::getDistance));
        return horses.get(horses.size()-1);
    }

    public void printWinner(){
        System.out.println("Winner is " +getWinner().name+"!");
    }

    public static void main(String[] args) throws InterruptedException {

        ArrayList<Horse> horses = new ArrayList<>();
        game = new Hippodrome(horses);

        Horse horse1 = new Horse("horse1", 3, 0);
        Horse horse2 = new Horse("horse2", 3, 0);
        Horse horse3 = new Horse("horse3", 3, 0);

        game.horses.add(horse1);
        game.horses.add(horse2);
        game.horses.add(horse3);
        game.run();
        game.printWinner();
    }
}
