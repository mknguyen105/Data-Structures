/**
 * Minh Nguyen
 * Karthika Saravanavijayan
 *Read in file, reverse string tokens, put into out file
 */
import java.io.*;
import java.util.Scanner;

public class FileReverse {
    public static void main(String args[]) throws IOException {
        Scanner in = new Scanner(new File(args[0]));
        PrintWriter out = new PrintWriter(new FileWriter(args[1]));
        while( in.hasNextLine() ) {
            String line = in.nextLine().trim() + " ";
            String[] token = line.split("\\s+");
            for(int i=0; i<token.length; i++){
                out.println(stringReverse(token[i]));
            }
        }
        in.close();
        out.close();
    }
    public static String stringReverse(String s){
        if (s.isEmpty()) {
            return s;
        }
        else
            return stringReverse(s.substring(1)) + s.charAt(0);
    }

}
