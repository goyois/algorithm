import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int answer = 0;
        for (int i = n-1; i > 0; i--) {
            while (true) {
                if (arr[i+1] > arr[i]) break;
                arr[i]--;
                answer++;
            }
        }
        System.out.println(answer);
    }
}
