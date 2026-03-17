
import java.io.*;
import java.util.*;

//스티커
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());

            int[][] arr = new int[2][n+1];
            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] dp = new int[2][n+1];
            dp[0][1] = arr[0][1];
            dp[1][1] = arr[1][1];

            for (int i = 2; i <= n; i++) {
                //이전 열의 값보다(i-1) 한칸 건너뛰고 대각선(i-2)을 고르는게 더 이득인 경우가 있으므로
                //비교해서 최댓값을 찾아낸다.
                dp[0][i] = Math.max(dp[1][i-2],dp[1][i-1]) + arr[0][i];
                dp[1][i] = Math.max(dp[0][i-2],dp[0][i-1]) + arr[1][i];
            }

            int answer = Math.max(dp[0][n],dp[1][n]);
            System.out.println(answer);
        }
    }
}
