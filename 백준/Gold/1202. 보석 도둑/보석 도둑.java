
import java.io.*;
import java.util.*;

//보석 도둑 우선순위 큐를 통한 최적화
public class Main {

    static class Jewel {
        int weight,price;

        public Jewel(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 보석의 갯수
        int k = Integer.parseInt(st.nextToken()); //가방의 갯수


        //보석을 무게 순으로 정렬
        Jewel[] jws = new Jewel[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken()); //보석의 무게
            int v = Integer.parseInt(st.nextToken()); //보석의 가격
            jws[i] = new Jewel(m,v);
        }
        Arrays.sort(jws,(o1,o2)-> Integer.compare(o1.weight,o2.weight));

        //가방은 가벼운 순으로 정렬
        int[] bags = new int[k];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken()); //가방에 담을 수 있는 무게
            bags[i] = c;
        }
        Arrays.sort(bags);


        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        long sum = 0;
        int idx = 0;
        for (int i = 0; i < k; i++) {
            while (idx < n && jws[idx].weight <= bags[i]) {
                //현재 가방 bags[i]에 담을 수 있는 모든 보석을 담음
                //idx 를 유지하면서 이미 큐에 들어간 보석은 다시 보지 않음
                max.offer(jws[idx].price);
                idx++;
            }
            if (!max.isEmpty()) sum += max.poll();
        }

        System.out.println(sum);
    }
}
