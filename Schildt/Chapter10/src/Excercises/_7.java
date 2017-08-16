package Excercises;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class _7 {

    public static void main(String[] args) {
        FileInputStream fis = null;
        FileOutputStream fos = null;

        int ch = -1;
        try {
            fis = new FileInputStream(args[0]);
            fos = new FileOutputStream(args[0] + "_copy");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
            do{
                try {
                    ch = fis.read();
                    if((char)ch == ' ')
                        ch = '-';
                    if (ch != -1)
                        fos.write(ch);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } while (ch != -1);

        if(fis != null)
            try {
                fis.close();
            }catch (IOException e) {
            e.printStackTrace();
        }

        if (fos != null)
            try {
            fos.close();
            }catch (IOException e){
            e.printStackTrace();
            }
    }
}
