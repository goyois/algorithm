import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Deque<Integer> deque = new LinkedList<>();

        while (n-- > 0) {
            String commandLine = br.readLine();
            StringTokenizer st = new StringTokenizer(commandLine);

            String command =  st.nextToken();
            int v = 0;

            if (command.equals("1")|| command.equals("2")) {
                v = Integer.parseInt(st.nextToken());
            }

            switch (command) {
                case "1":
                    deque.offerFirst(v);
                    break;
                case "2":
                    deque.offerLast(v);
                    break;
                case "3":
                    if (!deque.isEmpty()) sb.append(deque.pollFirst()+ "\n");
                     else sb.append(-1 + "\n");
                    break;
                case "4":
                    if (!deque.isEmpty()) sb.append(deque.pollLast()+"\n");
                     else sb.append(-1+"\n");
                    break;
                case "5":
                    sb.append(deque.size()+"\n");
                    break;
                case "6":
                    if (deque.isEmpty()) sb.append(1 + "\n");
                    else sb.append(0 + "\n");
                    break;
                case "7":
                    if (!deque.isEmpty()) sb.append(deque.peekFirst()+"\n");
                    else sb.append(-1 + "\n");
                    break;
                case "8":
                    if (!deque.isEmpty()) sb.append(deque.peekLast()+"\n");
                     else sb.append(-1+"\n");
                    break;
            }
        }

        System.out.println(sb.toString());

    }
}
