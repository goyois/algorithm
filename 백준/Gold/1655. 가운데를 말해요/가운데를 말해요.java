
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            //maxPq 를 통해 작은 값을 관리,minPq 로 큰 값 관리
            //갯수로 균형을 맞추고, 값을 뽑아낼 큐를 max 로 지정했으므로, max 에 먼저 넣어준다.
            if (maxPq.size() == minPq.size()) maxPq.offer(x);
            else minPq.offer(x);

            
            if (!maxPq.isEmpty() && !minPq.isEmpty()) {
                if (maxPq.peek() > minPq.peek()) {
                    
                    //만약 maxPq 의 루트값이 중간값이 아니게되는 경우(maxPq 가 minPq 보다 더 큰 경우)
                    //minPq 의 루트값과 위치를 바꿔준다.
                    int tmp = maxPq.poll();
                    maxPq.offer(minPq.poll());
                    minPq.offer(tmp);
                }
            }
            sb.append(maxPq.peek()).append("\n");
        }
        System.out.println(sb);
    }
}
