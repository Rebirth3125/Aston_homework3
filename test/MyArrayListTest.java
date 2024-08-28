import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MyArrayListTest {

    private MyArrayList<Integer> list;

    @BeforeEach
    public void setUp() {
        list = new MyArrayList<>();
    }

    @Test
    public void testAdd() {
        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(3, list.size());
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
    }

    @Test
    public void testGetWithValidIndex() {
        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
    }

    @Test
    public void testGetWithInvalidIndex() {
        list.add(1);
        list.add(2);
        list.add(3);

        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(3));
    }

    @Test
    public void testRemove() {
        list.add(1);
        list.add(2);
        list.add(3);

        int removed = list.remove(1);

        assertEquals(2, removed);
        assertEquals(2, list.size());
        assertEquals(1, list.get(0));
        assertEquals(3, list.get(1));
    }

    @Test
    public void testAddAll() {
        List<Integer> additionalList = Arrays.asList(4, 5, 6);
        list.add(1);
        list.add(2);
        list.add(3);

        list.addAll(additionalList);

        assertEquals(6, list.size());
        assertEquals(4, list.get(3));
        assertEquals(5, list.get(4));
        assertEquals(6, list.get(5));
    }

    @Test
    public void testClear() {
        list.add(1);
        list.add(2);
        list.add(3);

        list.clear();

        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(list.isEmpty());

        list.add(1);
        assertFalse(list.isEmpty());
    }

    @Test
    public void testBubbleSort() {
        list.add(3);
        list.add(1);
        list.add(4);
        list.add(5);
        list.add(2);

        list.bubbleSort();

        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
        assertEquals(4, list.get(3));
        assertEquals(5, list.get(4));
    }

    @Test
    public void testToString() {
        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals("[1, 2, 3]", list.toString());
    }

    @Test
    public void testEqualsAndHashCode() {
        MyArrayList<Integer> anotherList = new MyArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        anotherList.add(1);
        anotherList.add(2);
        anotherList.add(3);

        assertEquals(list, anotherList);
        assertEquals(list.hashCode(), anotherList.hashCode());
    }
}
