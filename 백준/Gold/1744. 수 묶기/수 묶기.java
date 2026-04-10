
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> negativePq = new PriorityQueue<>();
        PriorityQueue<Integer> positivePq = new PriorityQueue<>(Collections.reverseOrder());

        int o = 0;
        int z = 0;

        //1과 0을 따로 세고 처리한다.
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x > 1) positivePq.offer(x);
            else if (x == 1) o++;
            else if (x == 0) z++;
            else negativePq.offer(x);
        }

        long answer = 0;

        while (positivePq.size() > 1) answer += (long) positivePq.poll() * positivePq.poll();
        if (!positivePq.isEmpty()) answer += positivePq.poll();
        //1은 더하기 처리
        answer += o;

        while (negativePq.size() > 1) answer += (long) negativePq.poll() * negativePq.poll();
        //0이 들어온 게 없으면 전부 더함
        if (!negativePq.isEmpty()) if (z == 0) answer += negativePq.poll();
        System.out.println(answer);
    }
}
