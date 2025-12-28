import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    
    static int[] fibo;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        while (x-- > 0) {
            int n = Integer.parseInt(br.readLine());
            fibo = new int[n+1];
            if (n == 0) sb.append(1).append(" ").append(0).append("\n");
            else {
                Fibo(n);
                sb.append(fibo[n-1]).append(" ").append(fibo[n]).append("\n");
            }
        }
        System.out.println(sb);
    }


    static int Fibo(int n) {
        if (fibo[n] > 0) return fibo[n];
        if (n == 1) return fibo[n] = 1;
        else if (n == 0) return fibo[n] = 0;
        else return fibo[n] = Fibo(n-1) + Fibo(n-2);
    }
}
