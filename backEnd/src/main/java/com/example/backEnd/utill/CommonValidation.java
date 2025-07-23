package com.example.backEnd.utill;

public class CommonValidation {

    public static boolean stringNullValidation(String inputString) {
        return inputString == null || inputString.isEmpty();
    }

    public static boolean validateTaskTitle(String taskTitle) {
        return (taskTitle.length() < 3 || taskTitle.length() > 25);

    }

    public static boolean validateTaskDiscription(String taskDiscription) {
        return (taskDiscription.length() < 3 || taskDiscription.length() > 100);

    }
}