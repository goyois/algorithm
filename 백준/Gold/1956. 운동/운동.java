
import java.io.*;
import java.util.*;

public class Main {

    static int INF = 987654321;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        int[][] arr = new int[v+1][v+1];

        //i -> i 로 돌아와야하므로 일단 모든 칸 무한대(플로이드 워셜 진행 시 갱신되도록)
        for (int i = 1; i <= v; i++) {
                Arrays.fill(arr[i],INF);
        }

        //배열에 비용 초기화
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[a][b] = c;
        }


        //플로이드 워셜 진행
        for (int k = 1; k <= v; k++) {
            for (int i = 1; i <= v; i++) {
                for (int j = 1; j <= v; j++) {
                    if (arr[i][j] > arr[i][k] + arr[k][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
        }

        //arr[i][i] 값들만 확인하면 그것이 곧 각 노드를 포함하는 사이클의 최단 거리
        int answer = INF;
        for (int i = 1; i <= v; i++) {
            answer = Math.min(answer,arr[i][i]);
        }

        System.out.println(answer >= INF ? -1 : answer);
    }
}
