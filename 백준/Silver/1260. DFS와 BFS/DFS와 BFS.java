
import java.io.*;
import java.util.*;

public class Main {

    static int n,m,v;
    static ArrayList<ArrayList<Integer>> graph;
    static StringBuilder sb = new StringBuilder();
    static int[] dfsCh;
    static int[] bfsCh;


    public void DFS(int v) {
        dfsCh[v] = 1;
        sb.append(v+" ");
        for (int x : graph.get(v)) {
            if (dfsCh[x] == 0) {
                DFS(x);
            }
        }
    }

    public void BFS(int v) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(v);
        bfsCh[v] = 1;
        sb.append("\n");

        while (!q.isEmpty()) {
            int x = q.poll();
            sb.append(x).append(" ");
            for (int a : graph.get(x)) {
                if (bfsCh[a] == 0) {
                    bfsCh[a] = 1;
                    q.offer(a);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        dfsCh = new int[n+1];
        bfsCh = new int[n+1];

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (ArrayList<Integer> list : graph) {
            Collections.sort(list);
        }

        T.DFS(v);
        T.BFS(v);
        System.out.println(sb);
    }
}
