/**
 * Minh Nguyen
 *
 * 10/07/16
 */

public class Recursion {
    public static void main(String[] args){
        int[] A = {-1, 2, 6, 12, 9, 2, -5, -2, 8, 5, 7};
        int[] B = new int[A.length];
        int[] C = new int[A.length];
        int minIndex = minArrayIndex(A, 0, A.length-1);
        int maxIndex = maxArrayIndex(A, 0, A.length-1);
        for(int x: A) System.out.print(x+" ");
        System.out.println();
        System.out.println( "minIndex = " + minIndex );
        System.out.println( "maxIndex = " + maxIndex );
        reverseArray1(A, A.length, B);
        for(int x: B) System.out.print(x+" ");
        System.out.println();
        reverseArray2(A, A.length, C);
        for(int x: C) System.out.print(x+" ");
        System.out.println();
        reverseArray3(A, 0, A.length-1);
        for(int x: A) System.out.print(x+" ");
        System.out.println();
    }

    //reverse array from the end
    static void reverseArray1(int[] X, int n, int[] Y) {
        if (n > 0) {
            reverseArray1(X, n - 1, Y);
            Y[n - 1] = X[X.length - n];
        }
    }

    //reverse the array from the beginning
    static void reverseArray2(int[] X, int n, int[] Y) {
        if (n > 0) {
            reverseArray2(X, n - 1, Y);
            Y[X.length - n] = X[n - 1];
        }
    }

    //reverse the array by using temp char
    static void reverseArray3(int[] X, int i, int j) {
        if (i < j) {
            int copy = 0;
            copy=X[j];
            X[j] = X[i];
            X[i] = copy;
            reverseArray3(X, i+1, j-1);
        }
    }

    //recursive search for max array index by dividing array and recursing on each half
    static int maxArrayIndex(int[] X, int p, int r) {
        if (p == r)
            return p;
        else if (p < r){
            int q = (p + r) / 2;
            int m = maxArrayIndex(X, p, q);
            int n = maxArrayIndex(X, q + 1, r);
            if (X[m] > X[n]) q = m;
            else q = n;
            return q;
        }
        else return 0;
    }

    static int minArrayIndex(int[] X, int p, int r) {
        if (p == r)
            return p;
        else {
            int q = (p + r) / 2;
            int m = minArrayIndex(X, p, q);
            int n = minArrayIndex(X, q + 1, r);
            if (X[m] < X[n]) q = m;
            else q = n;
            return q;
        }
    }
}
