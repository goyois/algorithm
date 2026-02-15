
import java.util.*;
import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }

        Queue<Integer> out = new LinkedList<>();
        while (!q.isEmpty()) {
            for (int i = 1; i <= k; i++) {
                if (i == k) out.offer(q.poll());
                else q.offer(q.poll());
            }
        }

        if (out.size() > 1) {
            sb.append("<");
            int size = out.size();
            for (int i = 0; i < size - 1; i++) {
                sb.append(out.poll()).append(",").append(" ");
            }
            sb.append(out.poll());
            sb.append(">");
        } else {
            sb.append("<").append(out.poll()).append(">");
        }
        System.out.println(sb);
    }
}
