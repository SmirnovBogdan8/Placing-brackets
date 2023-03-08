package com.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
        System.out.println("Введите текст:");
        String input = scanner.nextLine();
        BracketChecker bracketChecker = new BracketChecker(input);
        System.out.println("Статус -> " + bracketChecker.check());
    }
}
