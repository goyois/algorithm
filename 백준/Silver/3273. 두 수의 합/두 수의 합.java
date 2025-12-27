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
        int x = Integer.parseInt(br.readLine());
        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        int lt = 0;
        int rt = n - 1;
        while (lt < rt) {
            int sum = arr[lt] + arr[rt];
            if (sum == x) {
                cnt++;
                lt++;
                rt--;
            } else if (sum > x) {
                rt--;
            } else lt++;
        }
        sb.append(cnt);
        System.out.println(sb);
    }
}

