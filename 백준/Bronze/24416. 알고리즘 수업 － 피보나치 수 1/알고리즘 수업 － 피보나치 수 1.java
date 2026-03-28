
import java.io.*;

public class Main {

    static int n;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        System.out.println(fibo(n));
        System.out.println(memoFibonacci());

    }

    //기본 피보나치
    public static int fibo(int x) {
        if (x == 0) return 0;
        if (x == 1 || x == 2) return 1;
        else return fibo(x - 1) + fibo(x - 2);
    }


    //메모이제이션 피보나치
    public static int memoFibonacci() {
        dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 1;
        int cnt = 1;
        
        for (int i = 3; i < n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
            cnt++;
        }
        
        return cnt;
    }

}
