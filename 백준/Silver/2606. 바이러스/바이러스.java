
import java.io.*;
import java.util.*;

public class Main {

    static int n,m;
    static int[] visited;
    static ArrayList<ArrayList<Integer>> graph;
    static int answer = 0;


    public void DFS(int v) {
        if (visited[v] == 0) visited[v] = 1;
        for (int i : graph.get(v)) {
            if (visited[i] == 0) {
                answer++;
                DFS(i);
            }
        }
    }


    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());

        visited = new int[n+1];
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

        T.DFS(1);

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
