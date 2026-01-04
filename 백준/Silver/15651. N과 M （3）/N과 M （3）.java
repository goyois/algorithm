
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    static int n,m;
    static int[] pm;

    static StringBuilder sb = new StringBuilder();
    public static void DFS(int L,int start) {
        if (L == m) {
            for (int x : pm) {
                sb.append(x).append(" ");
            }
            sb.append("\n");
        } else {
            for (int i = start; i <= n; i++) {
                pm[L] = i;
                DFS(L+1,start);
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        pm = new int[m];
        DFS(0,1);
        System.out.println(sb);
    }
}
