
import java.io.*;
import java.util.*;

//0-1냅색 유형
//벼락치기 (패턴은 동일하여 유형에 익숙해지도록 푸는 문제)
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //단원 개수
        int T = Integer.parseInt(st.nextToken()); //공부할 수 있는 총 시간

        int[][] dp = new int[N+1][T+1];
        int[] K = new int[1001];
        int[] S = new int[1001];

        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            K[i] = Integer.parseInt(st.nextToken());
            S[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= T; j++) {
                if (K[i] > j) dp[i][j] = dp[i-1][j];
                else dp[i][j] = Math.max(dp[i-1][j], S[i] + dp[i-1][j-K[i]]);
            }
        }

        System.out.println(dp[N][T]);

    }
}
