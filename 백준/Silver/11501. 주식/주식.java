import java.io.*;
import java.util.*;

//주식
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) arr[i] = Integer.parseInt(st.nextToken());
            
            int max = arr[n];
            long answer = 0;
            for (int i = n; i > 0; i--) {
                if (max < arr[i]) max = arr[i];
                else answer += max - arr[i];
            }
            System.out.println(answer);
        }
    }
}
