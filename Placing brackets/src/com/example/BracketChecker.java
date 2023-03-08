package com.example;

/**
 * класс для опредления расстановки скобок
 */
public class BracketChecker {
    /**
     * Вводимая строка скобок
     */
    private final String text;

    /**
     * Класс BracketChecker содержит один конструктор, который принимает на вход текст для проверки.
     * @param text параметр вводимой строки скобок
     */
    public BracketChecker(String text) {
        this.text = text;
    }

    /**
     * Метод check() проверяет расстановку скобок в тексте и возвращает статус "Success", если
     * скобки расставлены правильно, и "Error" в противном случае.
     * В методе check() используется класс (BracketStack<Character>), чтобы отслеживать открывающие
     * скобки. Если встречается открывающая скобка, она помещается в стек. Если встречается
     * закрывающая скобка, то проверяется, соответствует ли она последней открывающей скобке в стеке.
     * Если скобки не соответствуют друг другу, то возвращается "Error". Если после проверки стек
     * оказался пустым, то возвращается "Success", иначе - "Error".
     * @return статус о корректности строки скобок
     */
    public String check() {
        BracketStack<Character> stack = new BracketStack<>();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{' || ch == '<') {
                stack.push(ch);
            } else if (ch == ')' || ch == ']' || ch == '}' || ch == '>') {
                if (stack.isEmpty()) {
                    return "Error";
                }
                char top = stack.pop();
                if ((ch == ')' && top != '(') ||
                        (ch == ']' && top != '[') ||
                        (ch == '}' && top != '{') ||
                        (ch == '>' && top != '<')) {
                    return "Error";
                }
            }
        }
        return stack.isEmpty() ? "Success" : "Error";
    }
}
