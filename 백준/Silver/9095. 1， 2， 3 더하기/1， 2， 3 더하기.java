import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());

            int[] dp = new int[12];
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;

            for (int i = 4; i <= n; i++) {
                //n 별로 1,2,3 연산을 뜯어보면
                //n 의 1,2,3 연산은
                //n-3 의 연산식에 +1 연산식이 붙은 것과 같고
                //n-2 의 연산식에 +2 연산식이 붙은 것과 같고
                //n-1 의 연산식에 +3 연산식이 붙은 것과 같다
                dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
            }
            System.out.println(dp[n]);
        }
    }
}
