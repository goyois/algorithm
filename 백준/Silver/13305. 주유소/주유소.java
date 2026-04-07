
import java.io.*;
import java.util.*;

//그리디 주유소
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] vex = new int[n-1];
        int[] city = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < n-1; i++) vex[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) city[i] = Integer.parseInt(st.nextToken());

        long answer = 0; // 현재 비용

        //도시를 갈 때 마다 남은 리터가 0으로 떨어져야함
        //첫번째 도시에서는 무조건 이동할 수 있는 만큼 넣는다.
        //두번째 도시의 주유소 가격이 다음 도시 주유소 가격보다 싸면 다음 다음 거리만큼 더 넣고 간다.


        for (int i = 0; i < n-1; i++) {
            int cnt = 0;
            if (city[i] < city[i + 1]) {
                for (int j = i + 1; j < n - 1; j++) {
                    if (city[i] < city[j]) {
                        cnt++;
                    } else break;
                }
                answer += city[i] * (vex[i] + cnt);
            } else answer += city[i] * vex[i];

            if (cnt > 0) {
                i += cnt;
                cnt = 0;
            }
        }
        System.out.println(answer);
    }
}
