
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n];
        int answer = 1;
        dp[n-1] = 1;
        for (int i = n-2; i >= 0; i--) {
            int min = 0;
            for (int j = i+1; j < n; j++) {
                if (arr[i] > arr[j] && dp[j] > min) {
                    min = dp[j];
                }
            }
            dp[i] = min + 1;
            answer = Math.max(answer,dp[i]);
        }
        System.out.println(answer);


    }
}