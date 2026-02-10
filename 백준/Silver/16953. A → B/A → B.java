
import java.io.*;
import java.util.*;

public class Main {

    static Long a,b;


    public static void bfs(Long a) {
        Queue<Long> q = new ArrayDeque<>();
        q.offer(a);
        int L = 0;
        while (!q.isEmpty()) {
            L++;
            int len = q.size();
            for (int i = 0; i < len; i++) {
                long x = q.poll();
                long x1 = x * 2;
                long x2 = x * 10 + 1;
                if (x1 == b || x2 == b) {
                    System.out.println(L + 1);
                    return;
                }
                if (x1 < b) q.offer(x1);
                if (x2 < b) q.offer(x2);
            }
        }
        System.out.println(-1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Long.valueOf(st.nextToken());
        b = Long.valueOf(st.nextToken());
        bfs(a);


    }
}
