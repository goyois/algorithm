
import java.io.*;
import java.util.*;
public class Main {

    static int v,e,r;
    static int[] visited;
    static ArrayList<ArrayList<Integer>> graph;
    static Queue<Integer> q = new ArrayDeque<>();
    static int count = 1;

    public void BFS(int v) {
        visited[v] = count++;
        q.offer(v);

        while (!q.isEmpty()) {
            int tmp = q.poll();
            for (int x : graph.get(tmp)) {
                if (visited[x] == 0) {
                    visited[x] = count++;
                    q.offer(x);
                }
            }
        }
    }



    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        visited = new int[v+1];
        graph = new ArrayList<>();
        for (int i = 0; i <= v; i++){
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (ArrayList<Integer> list : graph) {
            Collections.sort(list,Collections.reverseOrder());
        }
        T.BFS(r);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < v+1; i++) sb.append(visited[i]).append("\n");
        System.out.println(sb);

    }
}
