
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n,m,r;
    static int[] ch;
    static ArrayList<ArrayList<Integer>> graph;
    static int L = 1;

    public void DFS(int v) {
        for (int x : graph.get(v)) {
            if (ch[x] == 0) {
                ch[x] = ++L;
                DFS(x);
            }
        }
    }




    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        ch = new int[n+1];
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (ArrayList<Integer> list : graph) {
            Collections.sort(list);
        }

        ch[r] = L;
        T.DFS(r);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n+1; i++) {
            sb.append(ch[i]).append("\n");
        }
        System.out.println(sb);
    }
}
