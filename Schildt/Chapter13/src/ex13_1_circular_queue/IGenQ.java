package ex13_1_circular_queue;

public interface IGenQ<T> {
    void put(T ch) throws QueueFullException;

    T get() throws QueueEmptyException;
}
