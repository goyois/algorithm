
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n+1][n+1];
        int[] dis = new int[n+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) arr[i][j] = 0;
                else arr[i][j] = 10000000;
            }
        }

        while (true){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == -1) break;
            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (arr[i][j] > arr[i][k] + arr[k][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
        }

        //최댓값을 찾는 변수 min
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            int answer = 0;
            for (int j = 1; j <= n; j++) {
                answer = Math.max(answer,arr[i][j]);
            }
            //배열에 각 친구별 점수 저장
            dis[i] = answer;
            min = Math.min(answer,min);
        }


        //인덱스(친구)를 뽑기 위해 최솟값을 가진 인원을 배열에 넣는다.
        int cnt = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (dis[i] == min){
                cnt++;
                list.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(min).append(" ").append(cnt).append("\n");
        for (int x : list){
            sb.append(x+" ");
        }

        System.out.println(sb);

    }
}
