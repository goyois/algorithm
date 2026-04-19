
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n+1][3];
        int[][] maxDp = new int[n+1][3];
        int[][] minDp = new int[n+1][3];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for (int j = 0; j < 3; j++) {
                dp[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for (int i = 1; i <= n; i++) {
            maxDp[i][0] = Math.max(maxDp[i-1][0],maxDp[i-1][1]) + dp[i][0];
            maxDp[i][1] = Math.max(maxDp[i-1][0],Math.max(maxDp[i-1][1],maxDp[i-1][2])) + dp[i][1];
            maxDp[i][2] = Math.max(maxDp[i-1][1],maxDp[i-1][2]) + dp[i][2];

            minDp[i][0] = Math.min(minDp[i-1][0],minDp[i-1][1]) + dp[i][0];
            minDp[i][1] = Math.min(minDp[i-1][0],Math.min(minDp[i-1][1],minDp[i-1][2])) + dp[i][1];
            minDp[i][2] = Math.min(minDp[i-1][1],minDp[i-1][2]) + dp[i][2];
        }
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            max = Math.max(maxDp[n][i],max);
            min = Math.min(minDp[n][i],min);
        }
        System.out.println(max+" "+min);
    }
}
