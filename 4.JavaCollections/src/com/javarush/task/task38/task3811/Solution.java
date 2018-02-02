package com.javarush.task.task38.task3811;

/* 
Тикеты
*/


@Ticket(
        priority = Ticket.Priority.HIGH,
        createdBy = "Noodles",
        tags = {"bug", "fix asap"}
)
public class Solution {
    public static void main(String[] args) {
        Class clazz = Solution.class;
        Ticket annotation = (Ticket) clazz.getAnnotation(Ticket.class);
        System.out.println(annotation.createdBy());
    }
}
