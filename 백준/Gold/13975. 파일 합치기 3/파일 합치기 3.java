
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Long> pq = new PriorityQueue<>();
        while (n-- > 0) {
            int m = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) pq.offer(Long.parseLong(st.nextToken()));

            long answer = 0;
            long sum = 0;
            int cnt = 0;
            while (!pq.isEmpty()) {
                sum += pq.poll();
                cnt++;
                if (cnt == 2) {
                    answer += sum;
                    pq.offer(sum);
                    sum = 0;
                    cnt = 0;
                }
            }
            System.out.println(answer);
        }
    }
}
