
import java.util.*;
import java.io.*;

public class Main {

    static class Priority {
        int priority;
        int index;

        public Priority(int p, int i) {
            this.priority = p;
            this.index = i;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            Queue<Priority> queue = new LinkedList<>();

            for (int i = 0; i < m; i++) {
                int p = Integer.parseInt(st.nextToken());
                    queue.offer(new Priority(p, i));
            }

            int cnt = 0;
            while (!queue.isEmpty()) {
                Priority x = queue.poll();
                for (Priority q : queue) {
                    if (x.priority < q.priority) {
                        queue.offer(x);
                        x = null;
                        break;
                    }
                }
                if (x != null) {
                    cnt++;
                }
                if (x != null && x.index == k) {
                    break;
                }
            }
            System.out.println(cnt);
        }
    }
}
