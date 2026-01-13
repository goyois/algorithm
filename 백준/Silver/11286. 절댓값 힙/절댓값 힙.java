import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2){
            if (Math.abs(o1) == Math.abs(o2)) return o1 - o2;
            else return Math.abs(o1) - Math.abs(o2);
            } 
        });
        
        while(N-- > 0){
            int x = Integer.parseInt(br.readLine());
            
            if (x != 0){
                pq.offer(x);
            } else {
                if (pq.isEmpty()){
                    sb.append("0").append("\n");
                } else {
                    pq.comparator();
                    sb.append(pq.poll()).append("\n");
                }  
            }
        }
        System.out.println(sb);
    }
}