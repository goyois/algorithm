
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        Deque<Integer> queue = new ArrayDeque<>();
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            if (cmd.equals("push")) {
                int v = Integer.parseInt(st.nextToken());
                queue.offer(v);
            } else if (cmd.equals("pop")) {
                if (!queue.isEmpty()) {
                    sb.append(queue.poll()+"\n");
                } else sb.append(-1+"\n");
            } else if (cmd.equals("size")) {
                sb.append(queue.size()+"\n");
            } else if (cmd.equals("empty")) {
                if (queue.isEmpty()) sb.append(1+"\n");
                else sb.append(0+"\n");
            } else if (cmd.equals("front")) {
                if (!queue.isEmpty()) sb.append(queue.peekFirst() +"\n");
                else sb.append(-1 + "\n");
            } else if (cmd.equals("back")) {
                if (!queue.isEmpty()) sb.append(queue.peekLast()+"\n");
                else sb.append(-1+"\n");
            }
        }
        System.out.println(sb.toString().stripTrailing());
    }
}
