import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            boolean isPrime = true;
            int tmp = Integer.parseInt(st.nextToken());
            if (tmp > 1) {
                for (int j = 2; j < tmp; j++) {
                    if (tmp % j == 0) {
                        isPrime = false;
                        break;
                    }
                }
                if (isPrime) cnt++;
            }
        }
        System.out.println(cnt);
    }
}
