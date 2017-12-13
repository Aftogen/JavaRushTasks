package com.javarush.task.task05.task0507;

/*
*Среднее арифметическое
Вводить с клавиатуры числа и вычислить среднее арифметическое.
Если пользователь ввел -1, вывести на экран среднее арифметическое всех чисел и завершить программу.
-1 не должно учитываться.

Пример для чисел 1 2 2 4 5 -1:
2.8

Пример для чисел 4 3 2 1 -1:
2.5


Требования:
1. Программа должна считывать данные с клавиатуры.
2. Программа должна выводить данные на экран.
3. Если ввести: 1 2 2 4 5 -1, программа должна вывести 2.8.
4. Если ввести: -100 0 100 -1, программа должна вывести 0.0.
5. Если ввести: 1 -1, программа должна вывести 1.0.
6. Выведенный результат должен соответствовать заданию для любых входных данных.*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        double sum = 0.0;
        int count = 0;
        for (; ; ) {
            int number = Integer.parseInt(sc.nextLine());
            if (number == -1) {
                if (count==0) count++;
                System.out.println(sum / count);
                break;
            }
            count++;
            sum += number;
            System.out.println(sum/count);
        }
        sc.close();
    }
}

