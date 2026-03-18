
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        int[] dp = new int[n];
        dp[0] = arr[0];
        int answer = arr[0];

        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = i-1; j >= 0; j--) {
                if (arr[i] > arr[j] && dp[j] > max) max = Math.max(max,dp[j]);
            }
            //dp 테이블에는 누적된 값 + 자기 자신의 값도 더해줌
            dp[i] = max + arr[i];
            answer = Math.max(answer,dp[i]);
        }
        System.out.println(answer);
    }
}
