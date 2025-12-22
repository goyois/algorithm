
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int num = (int) Math.round(n * 0.15);

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        for (int i = 0; i < num; i++) {
            arr[i] = 0;
            arr[arr.length-(i+1)] = 0;
        }

        int i;
        int c = 0;
        double sum = 0;
        for (i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                sum += arr[i];
            } else c++;
        }
        i=i-c;
        int res = (int) Math.round(sum / i);
      
        StringBuilder sb = new StringBuilder();
        sb.append(res);
        System.out.println(sb);
    }
}
