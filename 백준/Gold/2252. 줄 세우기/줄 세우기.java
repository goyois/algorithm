
import java.io.*;
import java.util.*;
//위상 정렬
public class Main {

    static int n,m;
    static List<List<Integer>> graph;
    static int[] indegree;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        //given
        indegree = new int[n + 1];
        graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            indegree[b]++;
        }

        topologicalSort();
    }


    static void topologicalSort() {
        Queue<Integer> q = new ArrayDeque<>(); //indegree 의 값이 0인 노드를 담을 큐
        Queue<Integer> res = new ArrayDeque<>(); //출력 결과를 담을 큐

        //큐에 indegree 가 0인 노드를 담음 (시작점)
        for (int i = 1; i < n + 1; i++) {
            if (indegree[i] == 0) q.offer(i);
        }


        while (!q.isEmpty()) {
            int node = q.poll();
            res.offer(node);

            for (int x : graph.get(node)) {
                indegree[x]--;

                if (indegree[x] == 0) q.offer(x);
            }
        }

        while (!res.isEmpty()) sb.append(res.poll()).append(" ");
        System.out.println(sb);
    }
}
