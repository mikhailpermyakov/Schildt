package Excercises;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

public class _8 {
    public static void main(String[] args) {

        char ch = '\u0000';

        try(FileReader fr = new FileReader(args[0]);
            FileWriter fw = new FileWriter(args[0] + "_copy");
        ){
            do{
                ch = (char) fr.read();
                if (ch != (char)-1)
                fw.write(ch);

            }while (ch != (char)-1);

        }catch (java.io.IOException e){
            e.printStackTrace();
        }
    }
}
