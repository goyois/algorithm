import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        st =  new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // n x n
        int m = Integer.parseInt(st.nextToken()); // 합을 구해야하는 횟수

        int[][] arr = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int x = Integer.parseInt(st.nextToken());
                //같은 행/ 이전 열 값 + 이전 행/같은 열 값에서 두 누적합의 수에서 겹치는 부분([i-1][j-1] 을 뺀 값 + x)
                arr[i][j] = arr[i][j-1] + arr[i-1][j] - arr[i-1][j-1] + x;
            }
        }

        while (m--> 0) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            //[1,1] ~ [x2,y2](까지의 전체 사각형까지의 합) - 구하고자 하는 영역보다 위의 구간 삭제 - 구하고자 하는 영역보다 왼쪽에 있는 구간 삭제
            // + 두 영역을 삭제할 때 2번 삭제된 값이 있으므로 그 값을 1번 더해준다.
            int sum = arr[x2][y2] - arr[x1-1][y2] - arr[x2][y1-1] + arr[x1-1][y1-1];
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}
