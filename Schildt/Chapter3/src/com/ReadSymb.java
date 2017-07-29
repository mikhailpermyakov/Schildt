package com;

import java.io.IOException;

/**
 * Created by Михаил on 29.07.2017.
 */
public class ReadSymb {
    public static void main(String[] args) throws IOException {
        char symb = '\u0000';
        char ignore = '\u0000';
        int spaceCounter = 0;

one:
        for(;;){
            symb = (char)System.in.read();
            do{
                ignore = (char)System.in.read();
            }while(ignore != '\n');
        switch (symb) {
            case '.': break one;
            case ' ': spaceCounter++;
        }
        }
        System.out.println("введена точка. пробелов: " + spaceCounter);
    }
}
