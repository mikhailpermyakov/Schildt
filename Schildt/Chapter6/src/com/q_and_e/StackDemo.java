package com.q_and_e;

class Stack {
    private char s[];
    private int putloc, prevPutloc;
    Stack (int size){
        s = new char[size + 1];
        prevPutloc = putloc = 0;
    }
    boolean push(char obj){

        if (putloc == s.length){
            System.out.println("stack overflow!!!");
            return false;
        }
        putloc++;
        s[putloc] = obj;
        return true;
    }
    char pop(){
        if(putloc == 0){
            System.out.println("stack is empty");
            return (char)0;
        }
        prevPutloc = putloc;
        putloc--;
        return s[prevPutloc];
    }
}
public class StackDemo{
    public static void main(String[] args) {
        Stack stack = new Stack(10);
        char chars[] = {'a','s','d','f','g','h','j','k','l',';'};
        for (int i = 0; i < 10; i++) {
            if(stack.push(chars[i])){
                System.out.println(i + "-th push successful... " + chars[i]);
            }
        }
        for (int i = 0; i < 10; i++) {
            System.out.println("extracting from stack " + stack.pop());
        }
    }
}