
import java.util.*;
import java.io.*;

public class Main {


    static class Meeting implements Comparable<Meeting>{
        int start,end;

        Meeting(int start,int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting m) {
            //끝나는 시간이 같으면 시작 시간 기준 오름차순
            if (this.end == m.end) return this.start - m.start;
            //기본 끝나는 시간 오름차순
            return Integer.compare(this.end,m.end);
        }
}

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Meeting> pq = new PriorityQueue<>();

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            pq.offer(new Meeting(start,end));
        }

        int answer = 0;
        int end = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            Meeting m = pq.poll();
            if (m.start >= end) {
                end = m.end;
                answer++;
            }
        }
        System.out.println(answer);
    }
}
