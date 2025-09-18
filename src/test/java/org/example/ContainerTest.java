package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainerTest {

    private Container<String> stringList;
    private Container<Integer> intList;

    @BeforeEach
    void setUp() {
        stringList = new Container<>();
        intList = new Container<>();
    }

    @Test
    void addLast() {
        stringList.addLast("a");
        stringList.addLast("b");
        stringList.addLast("c");

        assertEquals(3, stringList.size());
        assertFalse(stringList.isEmpty());
        assertEquals("a", stringList.get(0));
        assertEquals("b", stringList.get(1));
        assertEquals("c", stringList.get(2));
    }

    @Test
    void addFirst() {
        stringList.addFirst("a");
        stringList.addFirst("b");
        stringList.addFirst("c");

        assertEquals(3, stringList.size());
        assertEquals("c", stringList.get(0));
        assertEquals("b", stringList.get(1));
        assertEquals("a", stringList.get(2));
    }

    @Test
    void removeLast() {
        try {
            stringList.removeLast();
        } catch (Exception e) {
            fail("fail removeFirst");
        }
        assertEquals(0, stringList.size());
        assertTrue(stringList.isEmpty());

        stringList.addLast("only");
        stringList.removeLast();

        assertTrue(stringList.isEmpty());
        assertEquals(0, stringList.size());

        stringList.addLast("a");
        stringList.addLast("b");
        stringList.addLast("c");

        stringList.removeLast();
        assertEquals(2, stringList.size());
        assertEquals("a", stringList.get(0));
        assertEquals("b", stringList.get(1));

        stringList.removeLast();
        assertEquals(1, stringList.size());
        assertEquals("a", stringList.get(0));
    }

    @Test
    void removeFirst() {
        try {
            stringList.removeFirst();
        } catch (Exception e) {
            fail("fail removeFirst");
        }
        assertEquals(0, stringList.size());
        assertTrue(stringList.isEmpty());

        stringList.addLast("only");
        stringList.removeFirst();

        assertTrue(stringList.isEmpty());
        assertEquals(0, stringList.size());

        stringList.addLast("a");
        stringList.addLast("b");
        stringList.addLast("c");

        stringList.removeFirst();
        assertEquals(2, stringList.size());
        assertEquals("b", stringList.get(0));
        assertEquals("c", stringList.get(1));

        stringList.removeFirst();
        assertEquals(1, stringList.size());
        assertEquals("c", stringList.get(0));
    }

    @Test
    void removeByIndex() {
        stringList.addLast("test");
        assertThrows(IndexOutOfBoundsException.class, () -> stringList.removeByIndex(-1));

        stringList.removeLast();

        stringList.addLast("test");
        assertThrows(IndexOutOfBoundsException.class, () -> stringList.removeByIndex(1));

        stringList.removeLast();

        assertThrows(IndexOutOfBoundsException.class, () -> stringList.removeByIndex(0));

        stringList.addLast("only");
        stringList.removeByIndex(0);
        assertTrue(stringList.isEmpty());
        assertEquals(0, stringList.size());

        stringList.addLast("a");
        stringList.addLast("b");
        stringList.addLast("c");

        stringList.removeByIndex(1);
        assertEquals(2, stringList.size());
        assertEquals("a", stringList.get(0));
        assertEquals("c", stringList.get(1));
    }

    @Test
    void get() {
        stringList.addLast("test");
        assertThrows(IndexOutOfBoundsException.class, () -> stringList.get(-1));

        stringList.removeLast();

        stringList.addLast("test");
        assertThrows(IndexOutOfBoundsException.class, () -> stringList.get(1));

        stringList.removeLast();

        assertThrows(IndexOutOfBoundsException.class, () -> stringList.get(0));

        stringList.addLast("a");
        stringList.addLast("b");
        assertEquals("a", stringList.get(0));
    }

    @Test
    void size() {
        assertEquals(0, stringList.size());

        stringList.addLast("a");
        assertEquals(1, stringList.size());

        stringList.addLast("b");
        assertEquals(2, stringList.size());

        stringList.removeFirst();
        assertEquals(1, stringList.size());

        stringList.removeLast();
        assertEquals(0, stringList.size());
    }

    @Test
    void isEmpty() {
        assertTrue(stringList.isEmpty());

        stringList.addLast("test");
        assertFalse(stringList.isEmpty());
    }

    @Test
    void testToString() {
        assertEquals("[]", stringList.toString());

        stringList.addLast("a");
        stringList.addLast("b");
        stringList.addLast("c");
        assertEquals("[a, b, c]", stringList.toString());

        intList.addLast(1);
        intList.addLast(2);
        intList.addLast(3);
        assertEquals("[1, 2, 3]", intList.toString());
    }
}