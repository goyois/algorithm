
import java.util.*;
import java.io.*;


public class Main {

    static int[] move = {1,-1,2};
    static int n,m;
    static int minTime = Integer.MAX_VALUE;
    static int cnt = 0;

    public static void BFS(int start,int end) {
        int[] time = new int[100001];
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);

        while (!q.isEmpty()) {
            int tmp = q.poll();

            if (minTime < time[tmp]) return;
            if (time[tmp] <= minTime && tmp == end) {
                minTime = time[tmp];
                cnt++;
            }

            for (int i = 0; i < 3; i++) {
                int nx = tmp;
                if (i == 2) nx = nx * move[i];
                else nx = nx + move[i];

                if (nx >= 0 && nx < 100001) {
                    if (time[nx] == 0 || time[nx] >= time[tmp] + 1) {
                        time[nx] = time[tmp] + 1;
                        q.offer(nx);
                    }
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        BFS(n,m);
        System.out.print(minTime + "\n" + cnt);
    }
}
