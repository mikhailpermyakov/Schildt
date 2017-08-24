package ex13_1_circular_queue;

class GenQueue<T> implements IGenQ<T> {
    private T q[];

    private int putloc, getloc;

    GenQueue(T[] aRef){
        q = aRef;
        putloc = getloc = 0;
    }

    @Override
    public void put(T obj) throws QueueFullException {
        if(putloc+1 == getloc |((putloc == q.length - 1)&(getloc == 0)))
            throw new QueueFullException(q.length);

        if(putloc == q.length) putloc = 0;
        q[putloc++] = obj;
    }

    public T get() throws QueueEmptyException {
        if(getloc == putloc)
            throw new QueueEmptyException();

        return q[getloc++];
    }
}
