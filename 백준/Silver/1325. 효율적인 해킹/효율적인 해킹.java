
import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static ArrayList<Integer>[] graph;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph[B].add(A);
        }

        answer = new int[N + 1];
        int max = 0;
        for (int i = 1; i <= N; i++) {
            answer[i] = BFS(i);
            max = Math.max(max, answer[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (answer[i] == max) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
    }

    
    public static int BFS(int cur) {
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[N+1];

        q.offer(cur);
        visited[cur] = true;
        int cnt = 0;

        while (!q.isEmpty()) {
            int tmp = q.poll();
            cnt++;
            for (int next : graph[tmp]) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
        return cnt;
    }
}