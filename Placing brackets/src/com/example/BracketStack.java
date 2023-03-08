package com.example;

/**
 * Определяется класс Stack<T>, где T - это тип элемента, который будет храниться в стеке.
 * На данном примере элементы - это скобки.
 * @param <T> передаваемая строка со скобками
 */
public class BracketStack<T> {
    private int size;
    private T[] elements;

    /**
     *  В конструкторе происходит инициализация массива элементов с помощью оператора new Object[10].
     */
    public BracketStack() {
        size = 0;
        elements = (T[]) new Object[10];
    }

    /**
     * Метод push добавляет скобки в стек. Если стек заполнен,
     * увеличивается размер массива в два раза и копирует все элементы в новый массив
     * @param element количество передаваемых скобок
     */
    public void push(T element) {
        if (size == elements.length) {
            T[] newElements = (T[]) new Object[2 * elements.length];
            System.arraycopy(elements, 0, newElements, 0, elements.length);
            elements = newElements;
        }
        elements[size++] = element;
    }

    /**
     * @return Метод pop удаляет и возвращает последний добавленный элемент
     */
    public T pop() {
        if (size == 0) {
            throw new RuntimeException();
        }
        T element = elements[--size];
        elements[size] = null;
        return element;
    }

    /**
     * @return Метод peek возвращает последний добавленный элемент без его удаления
     */
    public T peek() {
        if (size == 0) {
            throw new RuntimeException();
        }
        return elements[size - 1];
    }

    /**
     * @return Метод isEmpty проверяет, пуст ли стек.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * @return Метод size возвращает размер стека.
     */
    public int size() {
        return size;
    }
}

