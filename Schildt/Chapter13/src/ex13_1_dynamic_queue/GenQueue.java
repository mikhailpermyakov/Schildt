package ex13_1_dynamic_queue;

class GenQueue<T> implements IGenQ<T> {
    private T q[];

    private int putloc, getloc;

    GenQueue(T[] aRef){
        q = aRef;
        putloc = getloc = 0;
    }

    public void put(T obj) throws QueueFullException {
        if(putloc == q.length-1) {
            T t[]= (T[])(new Object[q.length * 2]);
            //            T t[] = new T[q.length * 2];
            IGenQ.qCopy(q, t);
            q=t;
        }

        q[putloc++] = obj;
    }

    public T get() throws QueueEmptyException {
        if(getloc == putloc)
            throw new QueueEmptyException();

        return q[getloc++];
    }
}
