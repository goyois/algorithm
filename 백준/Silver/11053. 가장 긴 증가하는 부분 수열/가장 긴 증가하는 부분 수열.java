
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        int answer = 1;
        int[] dp = new int[n];
        dp[0] = 1;

        //현재 arr[i]에서 2중 for문을 통해 앞쪽 방향으로 순회하며 자신보다 큰 값을 찾는다
        //찾는다면 그 값(dp[j]) 을 max 로 저장하고 현재 위치(dp[i]) + 1 하여 넣는다.
        //그리고 answer 에 최댓값을 갱신해준다.
        for (int i = 1; i < n; i++) {
            //만약 arr[i] 앞에 큰 값이 없으면 1을 넣어줘야하는데
            //이중 for문 조건식에 따라 0 이면 +1 해서 1을 넣어줄 수 있음
            //그러므로 max 는 0 을 줘야함
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i] && dp[j] > max) max = dp[j];
            }
            dp[i] = max + 1;
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(answer);
    }
}
