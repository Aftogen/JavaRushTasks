package com.javarush.task.task38.task3810;

public @interface Author {
    String value() default "";

    Position position() default Position.OTHER;
}
