
import java.io.*;
import java.util.*;

//컵라면
public class Main {

    static class Problem implements Comparable<Problem>{
        int deadLine,cupRamen;

        public Problem(int deadLine, int cupRamen) {
            this.deadLine = deadLine;
            this.cupRamen = cupRamen;
        }

        //먼저 데드라인 기준 오름차순으로 정렬규칙을 설계한다 
        @Override
        public int compareTo(Problem p) {
            return Integer.compare(this.deadLine,p.deadLine);
        }
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Problem> deadLinePq = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            deadLinePq.offer(new Problem(d,c));
        }

        //라면 갯수를 담을 우선순위 큐를 만든다. 
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int answer = 0;
        //데드라인이 낮은 순으로 차례로 나올 때
        //라면 갯수를 담는 큐에 일단 라면 갯수를 넣어주고
        //현재 큐 사이즈(time)와 새로 들어오는 deadLine 을 비교해서
        //데드라인보다 시간이 더 지났다면 가장 적은 라면 갯수를 버린다(최댓값의 라면갯수만 남기게 됨) 
        for (int i = 0; i < n; i++) {
            Problem tmp = deadLinePq.poll();
            pq.offer(tmp.cupRamen);
            if (pq.size() > tmp.deadLine) pq.poll();
        }

        while (!pq.isEmpty()) answer += pq.poll();
        System.out.println(answer);
    }
}