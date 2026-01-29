
import java.io.*;
import java.util.*;

public class Main {

    static int n,m;
    static int[] pm,arr;
    static StringBuilder sb = new StringBuilder();

    public static void DFS(int L) {
        if (L == m) {
            for (int x : pm) {
                sb.append(x).append(" ");
            }
            sb.append("\n");
        } else {
            for (int i = 1; i <= n; i++) {
                pm[L] = arr[i];
                DFS(L+1);
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        pm = new int[m];
        arr = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        DFS(0);
        System.out.println(sb);

    }
}
