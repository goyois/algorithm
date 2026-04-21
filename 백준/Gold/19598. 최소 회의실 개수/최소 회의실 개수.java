
import java.io.*;
import java.util.*;

public class Main {

    static class Meeting {
        int start,end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Meeting> meetings = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            meetings.add(new Meeting(s,e));
        }

        Collections.sort(meetings,(o1,o2) -> {
            if (o1.start == o2.start) return o1.end - o2.end;
            else return o1.start - o2.start;
        });


        for (Meeting m : meetings) {
            if (!pq.isEmpty() && pq.peek() <= m.start) {
                pq.poll();
            } pq.offer(m.end);
        }
        System.out.println(pq.size());
    }
}

