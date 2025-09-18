package org.example;

/**
 * Реализация односвязного списка.
 * <p>
 * Класс предоставляет методы для добавления, удаления и поиска элементов.
 * Поддерживает generics для работы с любыми типами данных.
 *
 * @param <T> тип элементов в списке
 * @author Nikita Filippov
 * @version 1.1
 * @since 2025
 */
public class Container<T> {

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> head;
    private int size;

    /**
     * Создает новый пустой список.
     */
    public Container() {
        head = null;
        size = 0;
    }

    /**
     * Добавляет элемент в конец списка.
     *
     * @param data элемент для добавления
     */
    void addLast(T data) {
        Node<T> node = new Node<>(data);
        if (head == null) {
            head = node;
            size++;
        } else {
            Node<T> temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
            size++;
        }
    }

    /**
     * Добавляет элемент в начало списка.
     *
     * @param data элемент для добавления
     */
    void addFirst(T data) {
        Node<T> node = new Node<>(data);
        node.next = head;
        head = node;
        size++;
    }

    /**
     * Удаляет последний элемент списка.
     */
    void removeLast() {
        if (head == null) {
            return;
        } else if (head.next == null) {
            head = null;
            size--;
        } else {
            Node<T> temp = head;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null;
            size--;
        }
    }

    /**
     * Удаляет первый элемент списка.
     */
    void removeFirst() {
        if (head == null) {
            return;
        } else if (head.next == null) {
            head = null;
            size--;
        } else {
            head = head.next;
            size--;
        }
    }

    /**
     * Удаляет элемент списка по заданному индексу.
     *
     * @param index элемент для удаления
     * @throws IndexOutOfBoundsException если индекс выходит за границы диапазона
     */
    void removeByIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        if (index == 0) {
            head = head.next;
            size--;
        } else {
            Node<T> temp = head;
            int counter = 0;
            while (counter != index - 1) {
                temp = temp.next;
                counter++;
            }
            temp.next = temp.next.next;
            size--;
        }
    }

    /**
     * Возвращает элемент списка по заданному индексу.
     *
     * @param index элемент для возврата
     * @return элемент на указанной позиции
     * @throws IndexOutOfBoundsException если индекс выходит за границы диапазона
     */
    T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        Node<T> temp = head;
        int counter = 0;
        while (counter != index) {
            temp = temp.next;
            counter++;
        }
        return temp.data;
    }

    /**
     * Возвращает количество элементов в списке.
     *
     * @return количество элементов в списке
     */
    public int size() {
        return size;
    }

    /**
     * Проверяет список на пустоту.
     * <p>
     * @return {@code true} если список пустой, {@code false} в противном случае
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Возвращает строковое представление списка.
     * <p>
     * Формат: {@code [element1, element2, ..., elementN]}
     *
     * @return строковое представление списка
     */
    @Override
    public String toString() {
        if (head == null) {
            return "[]";  // Пустой список
        }

        String s = "[";
        Node<T> current = head;

        while (current != null) {
            s = s + current.data;
            if (current.next != null) {
                s = s + ", ";
            }
            current = current.next;
        }

        s = s + "]";
        return s;
    }
}
