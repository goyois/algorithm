import java.util.*;
import java.io.*;

public class Main {

    static int[] board;
    static int[] dice = {1,2,3,4,5,6};

    public static void bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[101];
        q.offer(1);
        int L = 0;

        while (!q.isEmpty()) {
            L++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int pos = q.poll();
                for (int j = 0; j < 6; j++) {
                    int np = pos + dice[j];
                    if (np == 100) {
                        System.out.println(L);
                        return;
                    }
                    //visited 배열을 통해 메모리 초과 방지(큐에 중복된 지점이 들어가서 메모리 초과됨)
                    //한번 방문한 위치는 재방문 x
                    if (np > 0 && np < 100) {
                        if (board[np] > 0) np = board[np];
                        if (!visited[np]) {
                            visited[np] = true;
                            q.offer(np);
                        }
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int ladder = Integer.parseInt(st.nextToken());
        int snake = Integer.parseInt(st.nextToken());

        board = new int[101];
        for (int i = 0; i < ladder+snake; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int jump = Integer.parseInt(st.nextToken());
            board[start] = jump;
        }
        bfs();
    }
}