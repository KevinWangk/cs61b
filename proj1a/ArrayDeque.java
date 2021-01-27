/**
 * ArrayDeque
 *
 * @author Wangkun
 * @create 2021-01-27-11:56
 **/
public class ArrayDeque<T> {
    private final int factor = 2;
    private int size = 0;
    private T[] arrDe;

    public ArrayDeque() {
        size = 0;
        arrDe = (T[]) new Object[8];
    }
    private void resize(int capacity, int position, int position1) {
        if (capacity <= 16){
            capacity = 16;
        }
        T[] a = (T[]) new Object[capacity];
        System.arraycopy(arrDe, position, a, position1, size);
        arrDe = a;
    }
    public void addFirst(T item) {
        int al = arrDe.length;
        if (size == arrDe.length) {
            al = size * factor;
        }
        resize(al, 0, 1);
        arrDe[0] = item;
        size = size + 1;
    }
    public void addLast(T item) {
        if (size == arrDe.length) {
            resize(size * factor, 0, 0);
        }
        arrDe[size] = item;
        size = size + 1;
    }
    public T removeFirst() {
        T rf = arrDe[0];
        size = size - 1;
        int rfs = arrDe.length;
        if ((size <= (arrDe.length * 0.25)) && (arrDe.length >= 16)) {
            rfs = size * factor;
        }
        resize(rfs, 1, 0);
        return rf;
    }
    public T removeLast() {
        T reLast = arrDe[size - 1];
        arrDe[size - 1] = null;
        size = size - 1;
        if ((size <= (arrDe.length * 0.25)) && (arrDe.length >= 16)) {
            resize(size * factor, 0, 0);
        }
        return reLast;
    }
    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public void printDeque() {
        int i = 0;
        while (i < size) {
            System.out.println(arrDe[i]);
            i = i + 1;
        }

    }
    public T get(int index) {
        if ((index + 1) > size) {
            return null;
        }
        return arrDe[index];
    }
}
