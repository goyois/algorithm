
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//N과M(9)
public class Main {
    static int n,m;
    static int[] pm,arr;
    static boolean[] ch;
    static StringBuilder sb = new StringBuilder();

    public static void DFS(int L) {
        if (L == m) {
            for (int x : pm) sb.append(x).append(" ");
            sb.append("\n");
        } else {
            int before = 0; //DFS(L+1) 을 통해 다시 호출되면 0으로 초기화됨 
            for (int i = 1; i <= n; i++) {
                if (!ch[i] && arr[i] != before) {
                    ch[i] = true;
                    pm[L] = arr[i];
                    before = arr[i];
                    DFS(L+1);
                    ch[i] = false;
                }
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
        ch = new boolean[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        DFS(0);
        System.out.println(sb);
    }
}
