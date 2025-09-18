package org.example;

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

    public Container() {
        head = null;
        size = 0;
    }

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

    void addFirst(T data) {
        Node<T> node = new Node<>(data);
        node.next = head;
        head = node;
        size++;
    }

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

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

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
