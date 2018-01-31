package com.javarush.task.task38.task3804;

public class Factory {

    public static Throwable getThrowable(Enum en)  {

        //null check
        if (en==null)
            return new IllegalArgumentException();

        String className = en.getDeclaringClass().getSimpleName();
        //Create message:
        String message  = en.name().toLowerCase().replaceAll("_", " ");
        message = Character.toString(message.charAt(0)).toUpperCase()+message.substring(1); //first letter uppercase

        switch (className) {
            case "ExceptionApplicationMessage":
                return  new Exception(message);
            case "ExceptionDBMessage":
                return new RuntimeException(message);
            case "ExceptionUserMessage":
                return new Error(message);
            default:
                return new IllegalArgumentException();
        }

    }

}
