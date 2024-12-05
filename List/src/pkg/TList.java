package pkg;

/**
 *
 * @param <T>:
 */

public interface TList<T> {
    void toHead();
    void toTail();
    void next() throws TException;
    void prev() throws TException;
    void addRight(T object) throws TException;
    void remove() throws TException;
    T currentValue() throws TException;
    boolean isOut();
    boolean isNull();
}
