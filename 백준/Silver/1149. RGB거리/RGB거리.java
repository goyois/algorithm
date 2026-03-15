
import java.io.*;
import java.util.*;

//RGB 거리
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][3];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //결과값이 들어가는 dp 테이블 초기화
        int[][] dp = new int[n][3];

        //dp 테이블에 0행의 값들은 초기화해둔다
        dp[0][0] = arr[0][0];
        dp[0][1] = arr[0][1];
        dp[0][2] = arr[0][2];

        //빨강,초록,파랑 각각 시작되는 케이스로 최솟값을 갱신한다.
        //2차원 배열의 n-1번 행의 원소를 순회하며 최솟값을 찾아서 리턴한다.

        //만족해야하는 조건.
        //1번 집의 색은 2번 집의 색과 같지 않아야 한다.
        //N번 집의 색은 N-1번 집의 색과 같지 않아야 한다.
        //i(2 ≤ i ≤ N-1)번 집의 색은 i-1번, i+1번 집의 색과 같지 않아야 한다.

        for (int i = 1; i < n; i++) {
            //이전 i-1 행에서 현재 칠하는 색상을 제외한 색상중에서 최솟값을 가진 색과 + 이전 행의 자신의 열 값 더해서 갱신한다.
            //red
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + arr[i][0];
            //green
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + arr[i][1];
            //blue
            dp[i][2] = Math.min(dp[i-1][0],dp[i-1][1]) + arr[i][2];
        }

        int result = Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2]));
        System.out.println(result);
    }
}
