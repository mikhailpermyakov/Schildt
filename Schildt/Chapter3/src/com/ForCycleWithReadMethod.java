package com;

import java.io.IOException;

public class ForCycleWithReadMethod {
    public static void main(String[] args) throws IOException {

        char ch='\u0000';

        for (int i = 0; ch != 'q';){
            ch = (char)System.in.read();
            if (ch == '\n') {
                i++;
                continue;
            }
            System.out.println("итерация №" + i + ", введённый символ: " + ch);
//            System.out.println(System.in.read());
        }
        System.out.println("угадал");
    }
}
