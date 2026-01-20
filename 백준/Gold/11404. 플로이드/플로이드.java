
import java.io.*;
import java.util.*;

public class Main {

    static int max = 10000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m =Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int[][] arr = new int[n+1][n+1];
        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <=n; j++) {
                arr[i][j] = max;
                if (i==j) arr[i][j] = 0;
            }
        }


        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    //시작 도시와 도착 도시를 연결하는 노선이 하나가 아닐 수 있으므로
                    //이후 같은 노선이 들어온다면 더 낮은 비용을 넣는다.
                    arr[a][b] = Math.min(arr[a][b],c);
                }
            }
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

        
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (arr[i][j] == max) arr[i][j] = 0;
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
