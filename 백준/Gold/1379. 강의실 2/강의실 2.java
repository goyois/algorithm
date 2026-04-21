
import java.io.*;
import java.util.*;

public class Main {

    static class Lecture {
        int num,start,end;

        public Lecture(int num, int start, int end) {
            this.num = num;
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Lecture> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int no = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list.add(new Lecture(no,s,e));
        }

        Collections.sort(list,(o1,o2) -> {
            if (o1.start == o2.start) return Integer.compare(o1.end,o2.end);
            else return Integer.compare(o1.start,o2.start);
        });

        PriorityQueue<int[]> pq1 = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        PriorityQueue<Integer> pq2 = new PriorityQueue<>();

        int[] res = new int[n + 1];
        int total = 0;

        for (Lecture l : list) {

            while (!pq1.isEmpty() && pq1.peek()[0] <= l.start) {
                pq2.offer(pq1.poll()[1]); // 방을 비우고 회의가 가능한 방을 관리하는 큐로 넘김
            }


            int num = 0;
            if (pq2.isEmpty()) num = ++total;
            else num = pq2.poll();

            //회의 종료 시간과 방 번호를 다시 pq1로 넘김(사용 중)
            pq1.offer(new int[]{l.end,num});
            res[l.num] = num; //원본 id 에 최종 배정된 방 번호 기록

        }

        StringBuilder sb = new StringBuilder();
        sb.append(total).append("\n");
        for (int i = 1; i <= n; i++) {
            sb.append(res[i]).append("\n");
        }
        System.out.println(sb);





    }
}
