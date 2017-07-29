package com;

/**
 * Created by Михаил on 29.07.2017.
 */
public class For1000_2 {
    public static void main(String[] args) {
        for (int i = 1000; i > 0 ; i -= 2) {
            System.out.print("" + i + "\t" + (i != 1000 & i%20 == 0? "\n":""));
        }
    }
}
