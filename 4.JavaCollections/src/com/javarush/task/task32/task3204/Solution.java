package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;

/* 
Генератор паролей
Реализуй логику метода getPassword, который должен возвращать ByteArrayOutputStream, в котором будут байты пароля.
Требования к паролю:
1) 8 символов.
2) только цифры и латинские буквы разного регистра.
3) обязательно должны присутствовать цифры, и буквы разного регистра.
Все сгенерированные пароли должны быть уникальные.

Пример правильного пароля:
wMh7smNu


Требования:
1. Класс Solution должен содержать метод getPassword(), который возвращает ByteArrayOutputStream со сгенерированным паролем.
2. Длина пароля должна составлять 8 символов.
3. Пароль должен содержать хотя бы одну цифру.
4. Пароль должен содержать хотя бы одну латинскую букву нижнего регистра.
5. Пароль должен содержать хотя бы одну латинскую букву верхнего регистра.
6. Пароль не должен содержать других символов, кроме цифр и латинских букв разного регистра.
7. Сгенерированные пароли должны быть уникальными.
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        String letters = "abcdefghijklmnopqrstuvwxyz";
        String digits = "0123456789";
        StringBuffer password = new StringBuffer();

        for (int i=0; i<4; i++) {
            password.append(letters.charAt((int)(Math.random()*26)));
        }
        for (int i=0; i<2; i++) {
            password.append(digits.charAt((int)(Math.random()*10)));
        }
        for (int i=0; i<2; i++) {
            password.append(letters.toUpperCase().charAt((int)(Math.random()*26)));
        }

        try {
            baos.write(password.toString().getBytes());
        } catch (Exception e)
        {

        }


        return baos;
    }
}