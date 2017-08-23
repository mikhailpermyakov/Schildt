package com;

class FixedQueue implements ICharQ{
    private char q[];
    private int putloc, getloc;
    private String state;

    FixedQueue(int size){
        q = new char[size + 1];
        putloc = getloc = 0;
    }

    synchronized public void put(char ch, boolean running) throws QueueFullException{
        if(!running){
            state = "put";
            notify();
            return;
        }

        if (putloc == q.length - 1)
            throw new QueueFullException(q.length - 1);

        putloc++;
        if (ch>'\u0000')
            q[putloc] = ch;

        state = "put";
        notify();
        try {
            while(!state.equals("got"))
                wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public char get(boolean running) throws QueueEmptyException {
        if(getloc == putloc) throw new QueueEmptyException();

        if(!running){
            state = "got";
            notify();
            return '\u0000';
        }
        getloc++;
        state = "got";
        notify();//?????
        //wait?????
            try {
                while (!state.equals("put"))
                    wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        return q[getloc];//??????
    }

}

class MyThread implements Runnable{
    Thread thread;
    private FixedQueue fq;

    public MyThread(String name, FixedQueue fq) {
        thread = new Thread(this, name);
        this.fq = fq;
        thread.start();
    }

    public void run(){
        char ch;
        int i;

        if(thread.getName().compareTo("putThread")==0) {
            try {
                for (i = 0; i < 11; i++) {
                    System.out.print("\nTrying to save: " + (char) ('A' + i));
                    fq.put((char) ('A' + i), true);
                    System.out.println(" - OK");
                }
                fq.put('\u0000', false);

            } catch (QueueFullException exc) {
                System.out.println(exc.getMessage());
            }
        } else {
            try{
                for (i = 0; i < 11; i++) {
                    System.out.print("Getting next symbol: ");
                    ch = fq.get(true);
                    System.out.println(ch);
                }
                fq.get(false);
            } catch (QueueEmptyException exc){
                System.out.println(exc.getMessage());
            }
        }
    }
}
public class QExcDemo {
    public static void main(String[] args) {
        FixedQueue q = new FixedQueue(10);

        MyThread mt1 = new MyThread("getThread", q);
        MyThread mt2 = new MyThread("putThread", q);

        try {
            mt1.thread.join();
            mt2.thread.join();
        }catch (InterruptedException exc){
            System.out.println("Main thread interrupted");
        }
    }
}
