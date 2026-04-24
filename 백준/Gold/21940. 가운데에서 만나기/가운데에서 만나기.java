
import java.io.*;
import java.util.*;

public class Main {

    static int INF = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //도시 개수
        int m = Integer.parseInt(st.nextToken()); //도로 개수

        int[][] dis = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i==j) dis[i][j] = 0;
                else dis[i][j] = INF;
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            dis[a][b] = c;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (dis[i][j] > dis[i][k] + dis[k][j]) {
                        dis[i][j] = dis[i][k] + dis[k][j];
                    }
                }
            }
        }

        int friendCount = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] friendPos = new int[friendCount];
        for (int i = 0; i < friendCount; i++) {
            friendPos[i] = Integer.parseInt(st.nextToken());
        }

        //모든 친구들이 i 번 도시로 모일 때의 최대 왕복 시간을 추출해서 담아야함
        int[] cityMaxTimes = new int[n+1];
        int minOfMaxTime = INF;

        for (int i = 1; i <= n; i++) {
            int max = Integer.MIN_VALUE;
            for (int pos : friendPos) {
                if (dis[pos][i] == INF || dis[i][pos] == INF) {
                    max = INF;
                    break;
                }
                max = Math.max(max,dis[pos][i] + dis[i][pos]);
            }
            cityMaxTimes[i] = max;
            if (max != INF) minOfMaxTime = Math.min(minOfMaxTime,max);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (cityMaxTimes[i] == minOfMaxTime) sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}
