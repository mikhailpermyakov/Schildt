package com;

class FixedQueue implements ICharQ{
    private char q[];
    private int putloc, getloc;

    public FixedQueue(int size){
        q = new char[size + 1];
        putloc = getloc = 0;
    }

    public void put(char ch) throws QueueFullException{
        if (putloc == q.length - 1)
            throw new QueueFullException(q.length - 1);

        putloc++;
        q[putloc] = ch;
    }

    public char get() throws QueueEmptyException {
        if(getloc == putloc) throw new QueueEmptyException();

        getloc++;
        return q[getloc];
    }

}


public class QExcDemo {
    public static void main(String[] args) {
        FixedQueue q = new FixedQueue(10);
        char ch;
        int i;

        try{
            for (i = 0; i < 11; i++) {
                System.out.print("Trying to save: " + (char)('A' + i));
                q.put((char) ('A' + i));
                System.out.println(" - OK");
            }
            System.out.println();
        } catch (QueueFullException exc){
            System.out.println(exc);
        }
        System.out.println();

        try{
            for (i = 0; i < 11; i++) {
                System.out.print("Getting next symbol: ");
                ch = q.get();
                System.out.println(ch);
            }
        } catch (QueueEmptyException exc){
            System.out.println(exc);
        }
    }
}
