
import java.io.*;
import java.util.*;

public class Main {

    static int n,m;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] visited;


    public void DFS(int v) {
        if (visited[v] == 0) visited[v] = 1;
        for (int i : graph.get(v)) {
            if (visited[i] == 0) {
                DFS(i);
            }
        }
    }



    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        visited = new int[n+1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int answer = 0;
        
        for (int i = 1; i <= n; i++) {
            if (visited[i] == 0) {
                answer++;
                T.DFS(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(answer);
        System.out.println(sb);
    }
}
