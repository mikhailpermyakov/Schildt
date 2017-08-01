package com.encode;

public class EnhancedEncode {
    public static void main(String[] args) {
        String msg = "This is a test";
        String encmsg = "";
        String decmsg = "";
        String key = "abcdefgi";
        int j;

        System.out.print("Original message: ");
        System.out.println(msg);

        j = 0;
        for (int i = 0; i < msg.length(); i++) {
            encmsg = encmsg + (char) (msg.charAt(i) ^ key.charAt(j));
            j++;
            if (j == 8) j = 0;
        }

        System.out.print("Encrypted message: ");
        System.out.println(encmsg);

        j=0;
        for (int i = 0; i < msg.length(); i++) {
            //building the decrypted message string
            decmsg = decmsg + (char) (encmsg.charAt(i) ^ key.charAt(j));
            j++;
            if(j == 8) j = 0;
        }

        System.out.print("Decrypted message: ");
        System.out.println(decmsg);
    }
}
