
import java.io.*;
import java.util.*;

//가운데를 말해요
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append((n / 2) + 1).append("\n");

            int cnt = 0;
            StringTokenizer st = null;
            PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> min = new PriorityQueue<>();

            for (int i = 1; i <= n; i++) {
                if (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());

                if (max.size() == min.size()) max.offer(x);
                else min.offer(x);

                if (!max.isEmpty() && !min.isEmpty()) {
                    if (max.peek() > min.peek()) {
                        int tmp = max.poll();
                        max.offer(min.poll());
                        min.offer(tmp);
                    }
                }

                //출력 줄바꿈 조건

                if (i % 2 != 0 && cnt < 11) {
                    sb.append(max.peek()).append(" ");
                    cnt++;
                    if (cnt == 10) {
                        sb.append("\n");
                        cnt = 0;
                    }
                }
            }

            sb.append("\n");
        }
        System.out.println(sb);
    }
}
