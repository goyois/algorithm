
import java.util.*;
import java.io.*;

//11725 트리의 부모 찾기
public class Main {

    static int n;
    static int[] dis;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        dis = new int[n+1];
        visited = new boolean[n+1];

        StringTokenizer st;
        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }

        dfs(1);

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= n; i++) {
            sb.append(dis[i]).append("\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int curr) {
        visited[curr] = true;
        for (int x : graph.get(curr)) {
            if (!visited[x]) {
                dis[x] = curr;
                dfs(x);
            }
        }
    }
}
