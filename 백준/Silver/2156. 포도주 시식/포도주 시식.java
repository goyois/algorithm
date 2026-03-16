import java.io.*;
import java.util.*;

//포도주 시식
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[10001];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[10001];
        dp[1] = arr[1];
        dp[2] = arr[1] + arr[2];
        
        for (int i = 3; i <= n; i++) {
            //포도주를 안 마셨음
            int d0 = dp[i-1];

            //포도주를 1잔째 마셨음
            int d1 = dp[i-2] + arr[i];

            //포도주를 2잔째 마셨음
            int d2 = dp[i-3] + arr[i] + arr[i-1];
            dp[i] = Math.max(d0,Math.max(d1,d2));
        }
        System.out.println(dp[n]);
    }
}
