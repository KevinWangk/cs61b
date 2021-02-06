package synthesizer;

/**
 * AbstractBoundedQueue Abstract
 *
 * @author Wangkun
 * @create 2021-02-06-15:46
 **/
public abstract class AbstractBoundedQueue <T> implements BoundedQueue <T> {
    protected int fillCount;
    protected int capacity;
    public int capacity() {
        return capacity;
    }
    public int fillCount() {
        return fillCount;
    }
}
