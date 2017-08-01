package com.encode;

import com.sun.org.apache.xpath.internal.SourceTree;

public class Encode {
    public static void main(String[] args) {
        String msg = "This is a test";
        String encmsg = "";
        String decmsg = "";
        int key = 88;

        System.out.print("Original message: ");
        System.out.println(msg);

        for (int i = 0; i < msg.length(); i++)
            encmsg = encmsg + (char) (msg.charAt(i) ^ key);

        System.out.print("Encrypted message: ");
        System.out.println(encmsg);

        for (int i = 0; i < msg.length(); i++)
            //building the decrypted message string
            decmsg = decmsg + (char)(encmsg.charAt(i) ^ key);

        System.out.print("Decrypted message: ");
        System.out.println(decmsg);
    }
}
