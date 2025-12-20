import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[6];
        for (int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int cnt = 0;
        int pack = 0;
        int pe = 0;
        for (int i = 1; i <= arr.length; i++) {
            cnt += arr[i-1] / T;
            if (arr[i-1] % T != 0) cnt++;
            if (P * i == n) pack = i;
        }
        if (pack == 0) pack = n / P;
        pe = n - P*pack;

        System.out.println(cnt);
        System.out.print(pack+" "+pe);
    }
}