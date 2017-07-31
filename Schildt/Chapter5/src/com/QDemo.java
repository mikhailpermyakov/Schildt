package com;


public class QDemo {

    public static void main(String[] args) {
        Queue bigQ = new Queue(100);
        Queue smallQ = new Queue(4);
        char ch;
        int i;

        System.out.println("using bigQ to save alphabet");
        for (i = 0; i < 26; i++) {
            bigQ.put((char)('A' + i));
        }

        System.out.println("content of bigQ: ");
        for (i = 0; i < 26; i++) {
            ch = (char)bigQ.get();
            if(ch != (char)0) System.out.println(ch);
        }
        System.out.println();

        System.out.println("using smallQ to generate errors");
        for (i = 0; i < 5; i++) {
            System.out.print("trying to save " +  (char)('Z' - i));
            smallQ.put((char)('Z' - i));
            System.out.println();
        }
        System.out.println();

        System.out.println("smallQ content: ");
        for (i = 0; i < 5; i++) {
            ch = (char)smallQ.get();
            if(ch != (char) 0) System.out.println(ch);

        }
    }
}
