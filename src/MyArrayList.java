import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

public class MyArrayList<T> implements MyList<T> {
    // Константы для начального размера и коэффициента увеличения
    private static final int DEFAULT_CAPACITY = 10;
    private static final int RESIZE_FACTOR = 2;

    private Object[] elements;
    private int size;

    public MyArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public void add(T element) {
        ensureCapacity(size + 1); // Включает добавляемый элемент
        elements[size++] = element;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T get(int index) {
        checkIndex(index);
        return (T) elements[index];
    }

    @Override
    @SuppressWarnings("unchecked")
    public T remove(int index) {
        checkIndex(index);
        T removedElement = (T) elements[index];
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elements, index + 1, elements, index, numMoved);
        }
        elements[--size] = null; // Помощь GC
        return removedElement;
    }

    @Override
    public void addAll(Collection<? extends T> collection) {
        Object[] array = collection.toArray();
        int numNew = array.length;
        ensureCapacity(size + numNew);
        System.arraycopy(array, 0, elements, size, numNew);
        size += numNew;
    }

    @Override
    public void clear() {
        Arrays.fill(elements, 0, size, null);
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void bubbleSort() {
        boolean sorted;
        for (int i = 0; i < size - 1; i++) {
            sorted = true;
            for (int j = 0; j < size - 1 - i; j++) {
                Comparable<T> element = (Comparable<T>) elements[j];
                if (element.compareTo((T) elements[j + 1]) > 0) {
                    swap(j, j + 1);
                    sorted = false;
                }
            }
            if (sorted) {
                break;
            }
        }
    }

    // Метод для увеличения емкости массива при необходимости
    private void ensureCapacity(int minCapacity) {
        if (minCapacity > elements.length) {
            resize(elements.length * RESIZE_FACTOR);
        }
    }

    // Метод для увеличения емкости до заданного размера
    private void resize(int newCapacity) {
        elements = Arrays.copyOf(elements, newCapacity);
    }

    // Метод для проверки валидности индекса
    private void checkIndex(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    // Метод для обмена элементов в массиве
    private void swap(int i, int j) {
        Object temp = elements[i];
        elements[i] = elements[j];
        elements[j] = temp;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MyArrayList<?> that)) return false;
        if (size != that.size) return false;
        for (int i = 0; i < size; i++) {
            if (!Objects.equals(elements[i], that.elements[i])) return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(elements);
        return result;
    }

    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(3);
        list.add(1);
        list.add(4);
        list.add(1);
        list.add(5);

        System.out.println("Before sorting:");
        System.out.println(list);

        list.bubbleSort();

        System.out.println("After sorting:");
        System.out.println(list);
    }
}
