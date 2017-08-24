package ex13_1_dynamic_queue;

public class QueueEmptyException extends Exception {
    @Override
    public String toString(){
        return "\nQueue is empty";
    }
}
