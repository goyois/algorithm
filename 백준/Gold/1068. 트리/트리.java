import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;
    static int n,remove;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        visited = new boolean[n+1];
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        int root = 0;
        for (int i = 0; i < n; i++){
            int p = Integer.parseInt(st.nextToken());
            if (p != -1) graph.get(p).add(i);
            else root = i;
        }

        remove = Integer.parseInt(br.readLine());
        if (remove == root) {
            System.out.println(0);
        } else {
            dfs(root);
            System.out.println(cnt);
        }
    }


    public static void dfs(int start) {
        visited[start] = true;
        int child = 0;
        for (int x : graph.get(start)) {
            if (x != remove && !visited[x]) {
                child++;
                dfs(x);
            }
        }
        if (child == 0) cnt++;
    }
}
