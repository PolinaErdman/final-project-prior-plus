package by.plus.priorbank.utils;

import com.github.javafaker.Faker;

public class User {
    public static String EMPTY_VALUE = "";

    public static String getEmail(){
        return new Faker().internet().emailAddress();
    }

    public static String getPassword(){
        return new Faker().internet().password();
    }
}
