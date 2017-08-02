package com.queue;


class Queue {
    private char q[];
    private int putloc, getloc;

    Queue(int size) {
        q = new char[size + 1];
        putloc = getloc = 0;
    }

    Queue (Queue ob){
        putloc = ob.putloc;
        getloc = ob.getloc;
        q = new char[ob.q.length];

        for (int i = getloc + 1; i <= putloc; i++) {
            q[i] = ob.q[i];
        }
    }

    Queue(char a[]){
        putloc = 0;
        getloc = 0;
        q = new char[a.length + 1];

        for (char anA : a) put(anA);
    }
    void put(char obj){
        if (putloc == q.length -1) {
            System.out.println("\nОчередь заполнена");
            return;
        }
        putloc++;
        q[putloc] = obj;
    }
    char get(){
        if (getloc == putloc){
            System.out.println("Очередь пуста");
            return (char)0;
        }
        getloc++;
        return q[getloc];
    }
}

public class QDemo {

    public static void main(String[] args) {
        //create empty queue that stores 10 elements
        Queue q1 = new Queue(10);

        char name[] = {'T', 'o', 'm'};
        //create queue based on the given array
        Queue q2 = new Queue(name);

        char ch;
        int i;

        //put a symbol set in the queue q1
        for (i = 0; i < 10; i++) {
            q1.put((char)('A' + i));
        }

        //create a queue based on another one
        Queue q3 = new Queue(q1);

        //show queues
        System.out.print("q1 content: ");
        for (i = 0; i < 10; i++) {
            ch = q1.get();
            System.out.print(ch);
        }
        System.out.println("\n");

        System.out.println("q2 content: ");
        for (i = 0; i < 3; i++) {
            ch = q2.get();
            System.out.println(ch);

        }

        System.out.println("\n");

        System.out.println("q3 content: ");
        for (i = 0; i < 10; i++) {
            ch = q3.get();
            System.out.print(ch);
        }
    }
}
