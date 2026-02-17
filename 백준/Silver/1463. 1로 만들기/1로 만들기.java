import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n+1];

        for (int i = 2; i <= n; i++) {
            //1 빼기
            dp[i] = dp[i-1] + 1;
            //2 나누기
            if (i % 2 == 0) dp[i] = Math.min(dp[i],dp[i / 2] + 1);
            //3 나누기
            if (i % 3 == 0) dp[i] = Math.min(dp[i],dp[i / 3] + 1);
        }
        System.out.println(dp[n]);
    }
}
