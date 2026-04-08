import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);

        long answer = 0;
        for (int i = 0; i < n; i++) {
            long curr = (long) arr[i] * (n - i);
            if (answer < curr) answer = curr;
        }
        System.out.println(answer);
    }
}
