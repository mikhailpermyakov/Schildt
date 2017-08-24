package ex13_1_dynamic_queue;

public class QueueFullException extends Exception {
    int size;

    QueueFullException(int size){
        this.size = size;
    }

    @Override
    public String toString(){
        return "\nQueue is full. Max queue size is " + size;
    }
}
