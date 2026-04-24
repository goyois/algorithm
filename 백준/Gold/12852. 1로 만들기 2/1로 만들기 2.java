import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n+1];
        int[] path = new int[n+1];

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            path[i] = i - 1;
            
            if (i % 2 == 0 && dp[i / 2] + 1 < dp[i]) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
                path[i] = i / 2;
            }
            
            if (i % 3 == 0 && dp[i / 3] + 1 < dp[i]) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
                path[i] = i / 3;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(dp[n]).append("\n");

        //n부터 시작
        while (n > 0) {
            sb.append(n).append(" ");
            n = path[n];
        }

        System.out.println(sb);
    }
}
