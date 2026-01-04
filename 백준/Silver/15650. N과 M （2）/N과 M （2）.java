
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int n,m;
    static int[] pm;

    public static void DFS(int L, int start) {
        if (L == m) {
            for (int x : pm) {
                System.out.print(x+ " ");
            }
            System.out.println();
        } else {
            for (int i = start; i <= n; i++) {
                pm[L] = i;
                DFS(L+1,i+1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        pm = new int[m];
        DFS(0,1);
    }
}
