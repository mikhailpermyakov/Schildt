package ex13_1_fixed_queue;

public interface IGenQ<T> {
    void put(T ch) throws QueueFullException;

    T get() throws QueueEmptyException;
}
