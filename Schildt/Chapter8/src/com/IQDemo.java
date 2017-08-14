package com;

class FixedQueue implements ICharQ{
    private char q[];
    private int putloc, getloc;

    public FixedQueue(int size){
        q = new char[size + 1];
        putloc = getloc = 0;
    }

    @Override
    public void put(char ch) {
        if (putloc == q.length-1){
            System.out.println(" - Queue is full");
            return;
        }
        putloc++;
        q[putloc] = ch;
    }

    @Override
    public char get() {
        if (getloc == putloc){
            System.out.println(" - Queue is empty");
            return (char)0;
        }
        getloc++;
        return q[getloc];
    }
}
class CircularQueue implements ICharQ{
    private char q[];
    private int putloc, getloc;

    public CircularQueue(int size) {
        q = new char[size + 1];
        putloc = getloc = 0;
    }
    public void put(char ch){
        if(putloc+1 == getloc |((putloc == q.length - 1)&(getloc == 0))){
            System.out.println(" -  Queue is full");
            return;
        }
        putloc++;
        if(putloc == q.length) putloc = 0;
        q[putloc] = ch;

    }
    public char get(){
        if(getloc == putloc){
            System.out.println(" - Queue is empty");
            return (char)0;
        }

        getloc++;
        if(getloc == q.length) getloc = 0;
        return q[getloc];
    }
}
class DynQueue implements ICharQ{
    private char q[];
    private int putloc, getloc;

    public DynQueue(int size){
        q=new char[size + 1];
        putloc = getloc = 0;
    }
    public void put(char ch){
        if(putloc == q.length-1){
            char t[] = new char[q.length * 2];
            for (int i = 0; i < q.length; i++) {
                t[i] = q[i];
            }
            q = t;
        }
        putloc++;
        q[putloc] = ch;
    }
    public char get(){
        if (getloc == putloc){
            System.out.println(" - Queue is empty");
            return (char)0;
        }
        getloc++;
        return q[getloc];
    }
}
public class IQDemo {
    public static void main(String[] args) {
        FixedQueue q1 = new FixedQueue(10);
        DynQueue q2 = new DynQueue(5);
        CircularQueue q3 = new CircularQueue(10);

        ICharQ iQ;

        char ch;
        int i;

        iQ = q1;

        for (i = 0; i < 10; i++)
            iQ.put((char)('A' + i));
        System.out.print("Fixed queue content: ");
        for (i = 0; i < 10; i++) {
            ch = iQ.get();
            System.out.print(ch);
        }
        System.out.println();

        iQ = q2;

        for (i = 0; i < 10; i++)
            iQ.put((char)('Z' - i));

        System.out.print("Dynamic queue content: ");
        for (i = 0; i < 10; i++) {
            ch = iQ.get();
            System.out.print(ch);
        }
        System.out.println();

        iQ = q3;
        for (i = 0; i < 10; i++)
            iQ.put((char)('A' + i));

        System.out.print("Circular queue content: ");
        for (i = 0; i < 10; i++) {
            ch = iQ.get();
            System.out.print(ch);
        }
        System.out.println();

        //put more symbols into circular queue

        for (i = 10; i < 20; i++)
            iQ.put((char)('A' + i));

        System.out.print("Circular queue content: ");
        for (i = 0; i < 10; i++) {
            ch= iQ.get();
            System.out.print(ch);
        }
        System.out.println("\nSaving and using circular queue data");

        for (i = 0; i < 20; i++) {
            iQ.put((char)('A'+i));
            ch = iQ.get();
            System.out.print(ch);

        }
    }

}
