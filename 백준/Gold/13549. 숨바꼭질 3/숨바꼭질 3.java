
import java.io.*;
import java.util.*;

public class Main {

    static int n,k;
    static boolean[] visited;

    static class Subin {
        int curr,time;
        Subin(int curr, int time) {
            this.curr = curr;
            this.time = time;
        }
    }

    public static void bfs(int start) {
        Deque<Subin> q = new ArrayDeque<>();
        visited = new boolean[100001];
        q.offer(new Subin(start,0));

        while (!q.isEmpty()) {
            int size = q.size();
            
            for (int i = 0; i < size; i++) {
                Subin tmp = q.poll();
                visited[tmp.curr] = true;

                if (tmp.curr == k) {
                    System.out.println(tmp.time);
                    return;
                }
                //0-1 알고리즘 bfs
                //가장 빠른 시간을 구해야하니까 비용이 0 인 간선이 있으므로 해당 비용이 드는 이동을 먼저 처리해야함
                if (tmp.curr * 2 < 100001 && tmp.curr * 2 > 0 && !visited[tmp.curr * 2]) {
                    q.offerFirst(new Subin(tmp.curr * 2, tmp.time));
                }
                if (tmp.curr + 1 < 100001 && tmp.curr + 1 > 0 && !visited[tmp.curr + 1]) {
                    q.offerLast(new Subin(tmp.curr + 1, tmp.time + 1));
                }
                if (tmp.curr - 1 >= 0 && !visited[tmp.curr - 1]) {
                    q.offerLast(new Subin(tmp.curr - 1, tmp.time + 1));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        bfs(n);
    }
}
