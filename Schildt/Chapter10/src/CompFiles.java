import java.io.*;

public class CompFiles {
    public static void main(String[] args) {
        int i = 0, j = 0;
        char chI = '\u0000', chJ = '\u0000';
        long position = 0;
        String caseSensitive = "0";

//        if (args.length != 2){
//            System.out.println("Usage: CompFiles file1 file2 CaseSensitivity(0|1)");
//            return;
//        }
        try(FileInputStream f1 = new FileInputStream("C:\\Users\\JRoff\\IdeaProjects\\Schildt\\Schildt\\Chapter10\\src\\Upper"/*args[0]*/);
            FileInputStream f2 = new FileInputStream("C:\\Users\\JRoff\\IdeaProjects\\Schildt\\Schildt\\Chapter10\\src\\Lower"/*args[1]*/))
        {
            if(args.length > 2)
                if(args[2].equals("0") || args[2].equals("1"))
                    caseSensitive = args[2];


            switch (caseSensitive) {
                case "0":
                {
                    do {
                        i = f1.read();
                        j = f2.read();

                        chI = Character.toLowerCase((char) i);
                        chJ = Character.toLowerCase((char) j);

                        position++;
                        if (chI != chJ) break;
                    } while (i != -1/* && j != -1*/);
                    if (chI != chJ)
                        System.out.println("Content of the files differs, starting from " + position + "th position");
                    else
                        System.out.println("Content matches");
                } break;
                case "1":
                {
                    do {
                        i = f1.read();
                        j = f2.read();

                        position++;
                        if (i != j) break;
                    } while (i != -1/* && j != -1*/);
                    if (i != j)
                        System.out.println("Content of the files differs, starting from " + position + "th position");
                    else
                        System.out.println("Content matches");
                } break;
            }



        } catch (IOException exc){
            System.out.println("Input-output error: " + exc);
        }
    }
}
