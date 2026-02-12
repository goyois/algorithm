
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] arr,pm;
    static boolean[] ch;
    static StringBuilder sb = new StringBuilder();

    public static void dfs(int L,int start) {
        if (L == 6) {
            for (int x : pm) {
                sb.append(x).append(" ");
            }
            sb.append("\n");
            return;
        } else {
            for (int i = start; i < n; i++) {
                if (!ch[i]) {
                    ch[i] = true;
                    pm[L] = arr[i];
                    dfs(L+1,i);
                    ch[i] = false;
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            if (line.equals("0")) break;

            n = Integer.parseInt(line);
            arr = new int[n];
            ch = new boolean[n];
            pm = new int[6];

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            dfs(0,0);
            System.out.println(sb);
            sb.setLength(0);
        }
    }
}
