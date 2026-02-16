
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Deque<Integer> deq = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            int x;
            if (cmd.equals("push_front")) {
                x = Integer.parseInt(st.nextToken());
                deq.offerFirst(x);
            } else if (cmd.equals("push_back")) {
                x = Integer.parseInt(st.nextToken());
                deq.offerLast(x);
            } else if (cmd.equals("pop_front")) {
                if (deq.isEmpty()) sb.append(-1);
                else sb.append(deq.pollFirst());
                sb.append("\n");
            } else if (cmd.equals("pop_back")) {
                if (deq.isEmpty()) sb.append(-1);
                else sb.append(deq.pollLast());
                sb.append("\n");
            } else if (cmd.equals("size")) {
                sb.append(deq.size());
                sb.append("\n");
            } else if (cmd.equals("empty")) {
                if (deq.isEmpty()) sb.append(1);
                else sb.append(0);
                sb.append("\n");
            } else if (cmd.equals("front")) {
                if (deq.isEmpty()) sb.append(-1);
                else sb.append(deq.peekFirst());
                sb.append("\n");
            } else if (cmd.equals("back")) {
                if (deq.isEmpty()) sb.append(-1);
                else sb.append(deq.peekLast());
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
