import java.io.*;
import java.util.*;

//카드 정렬하기
//priorityQueue + ds + greedy
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) pq.offer(Integer.parseInt(br.readLine()));

        int min = 0;
        if (n == 1) System.out.println(0);
        else {
            while (!pq.isEmpty()) {
                int sum = 0;
                for (int i = 0; i < 2; i++) {
                    sum += pq.poll();
                }
                min += sum;
                if (pq.isEmpty()) break;
                else pq.offer(sum);
            }
            System.out.println(min);
        }
    }
}