
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int[][] arr = new int[n][n];
        for (int[] r : arr) Arrays.fill(r,-1);

        //dp tbl
        int[][] dp = new int[n][n];

        arr[0][0] = Integer.parseInt(br.readLine());
        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = arr[0][0];

        for (int k = 1; k < n; k++) {
            for (int i = 0; i < k; i++) {
                dp[k][i] = Math.max(dp[k][i], dp[k-1][i] + arr[k][i]);
                dp[k][i+1] = dp[k-1][i] + arr[k][i+1];
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dp[n-1].length; i++) {
            max = Math.max(max,dp[n-1][i]);
        }
        
        System.out.println(max);
    }
}
