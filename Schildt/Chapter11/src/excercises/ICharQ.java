package com;

public interface ICharQ {
    void put(char ch, boolean running) throws QueueFullException;

    char get(boolean running) throws QueueEmptyException;

    //ICharQ reset();

    static void qCopy(char[] sourceQ, char[] destQ){
        if (destQ.length < sourceQ.length ) {
            System.out.println("Queue overflow...");
            return;
        }

        System.arraycopy(sourceQ, 0, destQ, 0, sourceQ.length);
    }
}