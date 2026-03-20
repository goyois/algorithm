
import java.io.*;
import java.util.*;

//가장 긴 증가하는 부분 수열4 + 역추적
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        int[] dp = new int[n];
        dp[0] = 1;
        int answer = 1;

        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = i-1; j >= 0; j--) {
                if (arr[i] > arr[j] && dp[j] > max) {
                    max = dp[j];
                }
            }
            dp[i] = max + 1;
            answer = Math.max(answer,dp[i]);
        }

        sb.append(answer).append("\n");

        //dp배열의 역순에서 출발
        //5 4 3 2 1 순위의 값을 찾고 그 인덱스에 해당하는 요소를 arr 에서 찾아 stack에 넣는다.    
        for (int i = n - 1; i >= 0; i--) {
            if (dp[i] == answer) {
                stack.push(arr[i]);
                answer--;
            }
        }

        while (!stack.isEmpty()) sb.append(stack.pop()).append(" ");
        System.out.println(sb);
    }
}
