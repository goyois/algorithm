
import java.io.*;
import java.util.*;

public class Main {

    static class Time implements Comparable<Time> {
        int start,end;

        Time(int start,int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Time t) {
            if (this.start == t.start) return this.end - t.end;
            return this.start - t.start;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Time[] times = new Time[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            times[i] = new Time(s,e);
        }

        Arrays.sort(times);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(times[0].end);

        for (int i = 1; i < n; i++) {
            if (pq.peek() <= times[i].start) pq.poll();
            pq.offer(times[i].end);
        }
        System.out.println(pq.size());
    }
}
