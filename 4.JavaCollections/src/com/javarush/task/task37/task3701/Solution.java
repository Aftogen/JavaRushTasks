package com.javarush.task.task37.task3701;

import java.util.ArrayList;
import java.util.Iterator;

/* 
Круговой итератор
Класс Solution наследуется от ArrayList.
Перегрузи правильным образом метод iterator в классе Solution.
Напишите свой класс RoundIterator внутри Solution, который будет итератором для списка Solution.
Итератор должен ходить по кругу по всем элементам.
В остальном поведение должно быть идентичным текущему итератору.

Требования:
1. Круговой итератор должен после последнего элемента переходить на первый и так далее.
2. Метод remove без параметров должен удалять текущий элемент.
3. При некорректной модификации списка из разных потоков должно возникать исключение ConcurrentModificationException.
4. Класс Solution должен быть потомком класса ArrayList.
5. Метод iterator() в классе Solution должен возвращать объект типа RoundIterator.
*/
public class Solution<T> extends ArrayList<T> {
    public static void main(String[] args) {
        Solution<Integer> list = new Solution<>();
        list.add(1);
        list.add(2);
        list.add(3);
        int count = 0;
        for (Integer i : list) {
            //1 2 3 1 2 3 1 2 3 1
            System.out.print(i + " ");
            count++;
            if (count == 10) {
                break;
            }
        }
    }
    @Override
    public Iterator<T> iterator() {
        return new RoundIterator();
    }
    public class RoundIterator implements Iterator<T> {
        Iterator<T> iterator = Solution.super.iterator();
        @Override
        public boolean hasNext() {
            if (size() == 0)
                return false;
            return true;
        }
        @Override
        public T next() {
            if (!iterator.hasNext())
                iterator = Solution.super.iterator();
            return iterator.next();
        }
        @Override
        public void remove() {
            iterator.remove();
        }
    }
}

