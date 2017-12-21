package com.javarush.task.task35.task3505;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertableUtil {

    /*
    * Реализуй логику метода convert в классе ConvertableUtil,
     * который должен возвращать словарь, значениями которого являются элементы
     * переданного cписка, а ключами являются объекты, полученные в
     * ызовом интерфейсного метода getKey.*/

    public static <T extends Convertable> Map convert(List<T> list) {
        Map result = new HashMap();

        for (T item: list)
            result.put(item.getKey(), item);

        return result;
    }
}
