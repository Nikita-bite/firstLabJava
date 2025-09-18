package org.example;


public class Main {
    public static void main(String[] args) {
        Container<Integer> listok = new Container<>();
        listok.addLast(10);
        listok.addLast(20);
        listok.addLast(30);
        listok.addLast(40);
        listok.addFirst(50);


        listok.removeByIndex(2);
        System.out.println(listok);
        listok.removeLast();
        System.out.println(listok);
        listok.removeFirst();
        System.out.println(listok);

        Container<String> listokString = new Container<>();
        listokString.addLast("a");
        listokString.addLast("b");
        listokString.addLast("c");
        listokString.addLast("d");
        listokString.addFirst("e");


        listokString.removeByIndex(1);
        System.out.println(listokString);
        listokString.removeLast();
        System.out.println(listokString);
        listokString.removeFirst();
        System.out.println(listokString);
    }
}