import java.io.*;

//*****
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 1;
        int sum = 0;

        while (true) {
            if (n <= sum + cnt) {
                if (cnt % 2 == 1) {
                    System.out.println((cnt - (n - sum - 1) + "/" + (n - sum)));
                    break;
                } else {
                    System.out.println((n - sum) + "/" + (cnt - (n - sum - 1)));
                    break;
                }
            } else {
                sum += cnt;
                cnt++;
            }
        }
    }
}
