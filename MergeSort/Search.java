/**
 * Minh Nguyen
 * implementation of merge sort and binary search on string array
 */

import java.io.*;
import java.util.Scanner;
import java.util.Arrays;

public class Search {
    public static void main(String[] args) throws IOException {
        // check number of command line arguments
        if(args.length <= 1){
            System.out.println("AAAGHHH");
            System.exit(1);
        }
        // count the number of lines in file
        Scanner inLine = new Scanner(new File(args[0]));
        int lineCount = 0;
        while( inLine.hasNextLine() ){
            inLine.nextLine();
            lineCount++;
        }
        inLine.close();
        // read file again to put in string array
        Scanner inString = new Scanner(new File(args[0]));
        int n = lineCount;
        int inputLineInt[] = new int[n];
        String[] inputStr = new String[n];
        for (int i=0; i<n; i++) {
            inputStr[i] = inString.nextLine();
            inputLineInt[i] = i+1;
        }
        inString.close();
        System.out.println("Input String:");
        System.out.println(Arrays.toString(inputStr));

        // sort string array
        mergeSort(inputStr, inputLineInt, 0, n-1);
        System.out.println("Sorted Input String:");
        System.out.println(Arrays.toString(inputStr));

        // read user input for word count
        // loop start at 1 to not input file name to string
        for (int j=1; j<args.length ; j++){
            String target = args[j];
            int lineFound = binarySearch(inputStr, inputLineInt, 0, n-1, target);
            if (lineFound>0) {
                System.out.print(target);
                System.out.print(" found on line " + lineFound + "\n");
            }
            else {
                System.out.print(target);
                System.out.print(" not found \n");
            }
        }
    }
    static void mergeSort(String[] word, int[] lineNumber, int p, int r){
        int q;
        if(p<r){
            q = (p+r)/2;
            mergeSort(word, lineNumber, p, q);
            mergeSort(word, lineNumber, q+1, r);
            merge(word, lineNumber, p, q, r);
        }
    }
    static void merge(String[] word, int[] lineNumber, int p, int q, int r){
        int n1 = q-p+1;
        int n2 = r-q;
        //temp strings
        String[] Lstr = new String[n1];
        String[] Rstr = new String[n2];
        int[] Lint = new int[n1];
        int[] Rint = new int[n2];
        int i, j, k;
        //copy word string to temp strings
        for(i=0; i<n1; i++){
            Lstr[i] = word[p+i];
            Lint[i] = lineNumber[p+i];
        }
        for(j=0; j<n2; j++){
            Rstr[j] = word[q+j+1];
            Rint[j] = lineNumber[q+j+1];
        }

        i = 0; j = 0;
        for (k=p; k<=r; k++){
            //compare words from Lstr and Rstr and copy to word array
            if( i<n1 && j<n2){
                //String s1 = Lstr[i];
                //String s2 = Rstr[j];
                if(Lstr[i].compareTo(Rstr[j])<0){
                    //System.out.println(Lstr[i] + " < " + Rstr[j]);
                    word[k] = Lstr[i];
                    lineNumber[k] = Lint[i];
                    i++;
                }else{
                    //System.out.println(Lstr[i] + " > " + Rstr[j]);
                    word[k] = Rstr[j];
                    lineNumber[k] = Rint[j];
                    j++;
                }

            //copy remaining words to word array
            }else if( i<n1 ){
                word[k] = Lstr[i];
                lineNumber[k] = Lint[i];
                i++;
            }else{ // j<n2
                word[k] = Rstr[j];
                lineNumber[k] = Rint[j];
                j++;
            }
            //System.out.println("k=" + k + " i=" + i + " j=" + j);
            //System.out.println(Arrays.toString(word));
        }
    }
    static int binarySearch(String[] word, int[] lineNumber, int p, int r,  String target){
        int q;
        if(p > r) {
            return -1;
        }else{
            q = (p+r)/2;
            if(target.equals(word[q])){
                return lineNumber[q];
            }else if(target.compareTo(word[q])<0){
                return binarySearch(word, lineNumber, p, q-1, target);
            }else{ // target > A[q]
                return binarySearch(word, lineNumber, q+1, r, target);
            }
        }
    }
}
