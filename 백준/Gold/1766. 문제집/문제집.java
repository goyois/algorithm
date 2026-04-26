import java.io.*;
import java.util.*;

//위상 정렬 - 문제집
public class Main {

    static int n,m;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[] indegree = new int[n + 1];
        //정렬시킬 노드의 비용(순위)
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            indegree[b]++;
        }
        topologicalSort(indegree,graph);
    }

    static void topologicalSort(int[] indegree,List<List<Integer>> graph) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i = 1; i <= n; i++) if (indegree[i] == 0) pq.offer(i);
            
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            int node = pq.poll();
            sb.append(node).append(" ");

            for (int x : graph.get(node)) {
                indegree[x]--;
                if (indegree[x] == 0) pq.offer(x);
            }
        }

        System.out.println(sb);
    }
}
