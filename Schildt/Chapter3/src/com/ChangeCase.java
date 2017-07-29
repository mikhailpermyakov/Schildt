package com;

import java.io.IOException;

public class ChangeCase {
    public static void main(String[] args) throws IOException {
        char symb = '\u0000', ignore;
        int caseChangedCounter = 0;
        for (;;) {
            symb = (char)System.in.read();
            do{
                ignore = (char)System.in.read();
            } while(ignore != '\n');
            if (symb == '.')
                break;
            if (symb <= 122 & symb >= 97) {
                symb -= 32;
                caseChangedCounter++;
                System.out.println(symb);
            } else if (symb <= 90 & symb >= 65){
                symb += 32;
                caseChangedCounter++;
                System.out.println(symb);
            }
        }
        System.out.println("введена точка. регистр менялся для " + caseChangedCounter + " символов");
    }
}
