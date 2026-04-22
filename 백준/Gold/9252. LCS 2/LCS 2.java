
import java.io.*;
import java.util.*;

public class Main {

    static int[][] LCS;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] a = br.readLine().toCharArray();
        char[] b = br.readLine().toCharArray();

        LCS = new int[a.length+1][b.length+1];


        for (int i = 1; i <= a.length; i++) {
            for (int j = 1; j <= b.length; j++) {
                if (a[i-1] == b[j-1]) LCS[i][j] = LCS[i-1][j-1] + 1;
                else LCS[i][j] = Math.max(LCS[i-1][j],LCS[i][j-1]);
            }
        }

        callStack(a,a.length,b.length);
        System.out.println(LCS[a.length][b.length]);
        System.out.println(sb);
    }

    static void callStack(char[] a, int i, int j) {

        Stack<Character> stack = new Stack<>();

        while (i > 0 && j > 0) {
            if (LCS[i][j] == LCS[i - 1][j]) {
                i--;
            } else if (LCS[i][j] == LCS[i][j - 1]) {
                j--;
            } else {
                stack.push(a[i-1]);
                i--;
                j--;
            }
        }
        while (!stack.isEmpty()) sb.append(stack.pop());
    }
}
