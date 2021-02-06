/**
 * Deque interface
 *
 * @author Wangkun
 * @create 2021-01-30-9:43
 **/
public interface Deque<T> {
    void addFirst(T item);
    void addLast(T item);

    boolean isEmpty();

    int size();

    void printDeque();

    T removeFirst();

    T removeLast();

    T get(int index);
}
