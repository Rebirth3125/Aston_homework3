import java.util.Collection;

interface MyList<T> {
    void add(T element);
    T get(int index);
    T remove(int index);
    void addAll(Collection<? extends T> collection);
    void clear();
    boolean isEmpty();
    int size();
    void bubbleSort();
}