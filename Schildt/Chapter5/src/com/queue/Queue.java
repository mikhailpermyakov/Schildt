package com.queue;

class Queue {
    Object objects[];
    int putloc, getloc;

    Queue(int size) {
        objects = new Object[size + 1];
        putloc = getloc = 0;
    }

    void put(Object obj){
        if (putloc == objects.length -1) {
            System.out.println("Очередь заполнена");
            return;
        }
        putloc++;
        objects[putloc] = obj;
    }
    Object get(){
        if (getloc == putloc){
            System.out.println("Очередь пуста");
            return (char)0;
        }
        getloc++;
        return objects[getloc];
    }
}
