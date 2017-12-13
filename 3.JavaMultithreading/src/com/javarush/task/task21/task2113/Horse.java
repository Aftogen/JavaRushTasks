package com.javarush.task.task21.task2113;

public class Horse {
    String name;
    double speed, distance;
    public void move(){
        distance += speed * Math.random();
    }

    public void print(){
        StringBuilder sb = new StringBuilder();
        int dist = (int) distance;
        for (int i = 0; i<dist;i++){
            sb.append(".");
        }
        sb.append(name);
        System.out.println(sb);
    }

    public Horse(String name, double speed, double distance) {
        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public double getSpeed() {
        return speed;
    }

    public double getDistance() {
        return distance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
