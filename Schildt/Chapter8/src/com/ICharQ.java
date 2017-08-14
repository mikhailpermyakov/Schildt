package com;

public interface ICharQ {
    void put(char ch);

    char get();

    ICharQ reset();

    static void qCopy(char[] sourceQ, char[] destQ){
        if (destQ.length < sourceQ.length ) {
            System.out.println("Queue overflow...");
            return;
        }

        for (int i = 0; i < sourceQ.length; i++) {
            destQ[i] = sourceQ[i];
        }
    }
}