
import java.util.*;
import java.io.*;

//2xN 타일링
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        //직접 그려보면 피보나치 수열의 성질을 띄고 있음
        int[] dp = new int[n+1];
        dp[1] = 1;
        if (n > 1) dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i-2] + dp[i-1]) % 10007;
        }

        System.out.println(dp[n]);
    }
}
