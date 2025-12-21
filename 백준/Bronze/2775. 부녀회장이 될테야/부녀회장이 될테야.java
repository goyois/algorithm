
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[k+1][n];
            for (int i = 0; i < 1; i++) {
                for (int j = 1; j <= n; j++) {
                    arr[i][j-1] = j;
                }
            }
            //1층 1호부터 값을 미리 계산해준다.
            for (int i = 1; i <= k; i++) {
                int sum = 0;
                //1호 ~ n호까지
                //1호는 k-1층 상관없이 이전 호수가 없는 첫 집이므로 인원수: 1
                arr[i][0] = 1;
                sum = 1;
                for (int j = 1; j < n; j++) {
                    sum += arr[i-1][j];
                    arr[i][j] = sum;
                }
            }
            System.out.println(arr[k][n-1]);
        }
    }
}
