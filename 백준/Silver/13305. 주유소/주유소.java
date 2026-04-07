import java.io.*;
import java.util.*;

//그리디 주유소
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] vex = new long[n-1];
        long[] city = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < n-1; i++) vex[i] = Long.parseLong(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) city[i] = Long.parseLong(st.nextToken());

        
        
        //내 도시의 주유소보다 앞으로 갈 도시의 주유소가 더 비싸면 그 도시 갯수를 세고
        //내 도시에서부터 내 도시 주유소보다 비싸면 
        //해당 도시에서 다음 도시로 가기 위한 거리만큼 내 도시의 가격으로 더 넣는다.
        //그리고 다음 loop 에서 도시 갯수만큼 점프한 위치에서 시작한다.

        long answer = 0;
        for (int i = 0; i < n-1; i++) {
            int cnt = 0;
            long cost = 0;

            if (city[i] < city[i + 1]) {
                for (int j = i + 1; j < n - 1; j++) {
                    if (city[i] < city[j]) {
                        cnt++;
                        cost += city[i] * vex[j];
                    } else break;
                }
                answer += (city[i] * vex[i]) + cost;
            } else answer += city[i] * vex[i];
            i += cnt;
        }
        System.out.println(answer);
    }
}