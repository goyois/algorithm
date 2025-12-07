import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++){
            queue.offer(i+1);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        int cnt = 0;
        while (queue.size() > 1) {
            cnt++;
            if (cnt == k) {
                sb.append(queue.poll()+","+" ");
                cnt = 0;
            } else queue.offer(queue.poll());
        }
        sb.append(queue.poll());
        sb.append(">");
        
        System.out.println(sb.toString());
    }
}
