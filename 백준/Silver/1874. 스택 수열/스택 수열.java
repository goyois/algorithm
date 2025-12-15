
import java.io.*;
import java.util.*;

//svr2 스택 수열
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            queue.offer(i+1);
        }
        
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();

        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            s1.append(v);
            while(true) {
                if (!stack.isEmpty()) {
                    if (stack.peek() == v) {
                        s2.append(stack.peek());
                        stack.pop();
                        sb.append("-" + "\n");
                        break;
                    } else {
                        if (!queue.isEmpty()) {
                            stack.push(queue.poll());
                            sb.append("+" + "\n");
                        } else break;
                    }
                } else {
                    if (!queue.isEmpty()) {
                        stack.push(queue.poll());
                        sb.append("+" + "\n");
                    } else break;
                }
            }
        }
        if (s1.toString().equals(s2.toString())) {
            System.out.println(sb.toString().stripTrailing());
        } else System.out.println("NO");
    }
}
