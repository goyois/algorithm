
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> queue = new LinkedList<>();

        while (n-- > 0) {
            String commandLine = br.readLine();
            StringTokenizer st = new StringTokenizer(commandLine);

            String command = st.nextToken();
            int value = 0;

            if (command.equals("push")) {
                value = Integer.parseInt(st.nextToken());
            }

            switch (command) {
                case "push":
                    queue.offer(value);
                    break;
                case "pop":
                    if (!queue.isEmpty()) {
                        sb.append(queue.poll()).append('\n');
                    } else sb.append(-1).append('\n');
                    break;
                case "size":
                    sb.append(queue.size()).append('\n');
                    break;
                case "empty":
                    if (queue.isEmpty()) sb.append(1).append('\n');
                    else sb.append(0).append('\n');
                    break;
                case "front":
                    if (!queue.isEmpty()) {
                        sb.append(queue.peekFirst()).append('\n');
                    } else sb.append(-1).append('\n');
                    break;
                case "back":
                    if (!queue.isEmpty()) {
                        sb.append(queue.peekLast()).append('\n');
                    } else sb.append(-1).append('\n');
                    break;
            }
        }

        System.out.println(sb.toString());
    }
}
