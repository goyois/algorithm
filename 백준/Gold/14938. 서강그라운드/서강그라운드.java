
import java.io.*;
import java.util.*;

public class Main {

    static final int max = 10000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //지역의 개수
        int m = Integer.parseInt(st.nextToken()); //수색 가능 범위
        int r = Integer.parseInt(st.nextToken()); //길의 개수


        int[][] arr = new int[n+1][n+1]; //2차원 인접행렬
        int[] item = new int[n+1]; //지역별 아이템 개수

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            item[i] = Integer.parseInt(st.nextToken()); //지역별 아이템의 개수
            for (int j = 1; j <= n; j++) {
                arr[i][j] = max;
                if (i == j) arr[i][j] = 0;
            }
        }

        while (r-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    arr[a][b] = Math.min(arr[a][b],w);
                    arr[b][a] = Math.min(arr[b][a],w);
                }
            }
        }


        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    arr[i][j] = Math.min(arr[i][j],arr[i][k] + arr[k][j]);
                }
            }
        }

        int result = 0;
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = 1; j <= n; j++) {
                if (arr[i][j] <= m) {
                    sum += item[j];
                }
            }
            result = Math.max(sum,result);
        }
        System.out.println(result);
    }
}