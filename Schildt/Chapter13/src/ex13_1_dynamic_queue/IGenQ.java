package ex13_1_dynamic_queue;

public interface IGenQ<T> {
    void put(T ch) throws QueueFullException;

    T get() throws QueueEmptyException;

    static void qCopy(Object[] sourceQ, Object[] destQ) throws QueueFullException{
        if (destQ.length < sourceQ.length ) {
            throw new QueueFullException(destQ.length);
        }

        for (int i = 0; i < sourceQ.length; i++) {
            destQ[i] = sourceQ[i];
        }
    }
}
