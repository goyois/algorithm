
import java.io.*;
import java.util.*;

public class Main {

    static int n,m;
    static int[] visited;
    static ArrayList<ArrayList<Integer>> graph;
    static int cnt = 0;


    public void DFS(int v) {
        if (visited[v] == 0) visited[v] = 1;
        for (int i : graph.get(v)) {
            if (visited[i] == 0) {
                DFS(i);
                cnt++;
            }
        }
    }



    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        visited = new int[n+1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }


        for (int i = 1; i <= n; i++) {
            if (!graph.get(i).isEmpty()) {
                if (cnt > 0) break;
                if (visited[i] == 0) {
                    T.DFS(i);
                }
            }
        }

        int answer = 0;
        for (int x : visited) {
            answer += x;
        }

        if (answer == 0) System.out.println(0);
        else System.out.println(answer-1);
    }
}
