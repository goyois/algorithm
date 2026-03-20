
import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp1 = new int[n];
        dp1[0] = 1;
        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = i-1; j >= 0; j--) {
                if (arr[i] > arr[j] && dp1[j] > max) max = dp1[j];
            }
            dp1[i] = max + 1;
        }

        int[] dp2 = new int[n];
        dp2[n-1] = 1;
        for (int i = n-2; i >= 0; i--) {
            int min = 0;
            for (int j = i+1; j < n; j++) {
                if (arr[i] > arr[j] && dp2[j] > min) min = dp2[j];
            }
            dp2[i] = min + 1;
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            //증가하는 수열 + 감소하는 수열을 합치면 정상으로 가정한 지점이 2개가 됨
            //{10,20,30} + {30,25,20} = {10,20,30,30,25,20}
            //그러므로 중복된 정상을 1개 제거하는 것
            answer = Math.max(answer,(dp1[i] + dp2[i]) - 1);
        }
        System.out.println(answer);
    }
}
