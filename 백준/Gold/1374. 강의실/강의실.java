
import java.io.*;
import java.util.*;

public class Main {

    static class Lecture {
        int no,start,end;

        public Lecture(int no, int start, int end) {
            this.no = no;
            this.start = start;
            this.end = end;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Lecture> list = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list.add(new Lecture(number,s,e));
        }

        Collections.sort(list,((o1, o2) -> {
            if (o1.start == o2.start) return o1.end - o2.end;
            else return o1.start - o2.start;
        }));


        for (Lecture l : list) {
            if (!pq.isEmpty() && pq.peek() <= l.start) pq.poll();
            pq.offer(l.end);
        }
        System.out.println(pq.size());

    }
}
