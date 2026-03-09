
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;

        //자료구조 순번 저장
        int[] ds = new int[n];
        int[] curr = new int[n];

        //자료구조 종류 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) ds[i] = Integer.parseInt(st.nextToken());

        //초기 원소 값
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) curr[i] = Integer.parseInt(st.nextToken());

        //삽입될 원소 수
        int m = Integer.parseInt(br.readLine());

        //삽입될 원소를 담을 배열
        int[] insertArr = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) insertArr[i] = Integer.parseInt(st.nextToken());

        Deque<Integer> deq = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        //스택은 들어갔다가 다시 나오는 구조이므로 pass 
        //큐라면 해당 원소를 맨앞으로 넣는다 
        for (int i = 0; i < n; i++) if (ds[i] == 0) deq.offerFirst(curr[i]);
        
        //삽입될 원소를 한개씩 뒤로 넣고 맨앞 원소를 빼준다
        for (int i = 0; i < m; i++) {
            deq.offerLast(insertArr[i]);
            sb.append(deq.pollFirst()).append(" ");
        }

        System.out.println(sb);
    }
}