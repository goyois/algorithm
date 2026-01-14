import java.io.*;
import java.util.*;

public class Main {

    static int n,m;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int[][] board;
    static int answer = 0;
    static Queue<Point> q = new LinkedList<>();
    static int max = 0;

    static class Point {
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    public static void BFS(int x, int y) {
        int cnt = 1;
        q.offer(new Point(x,y));
        while (!q.isEmpty()) {
            Point tmp = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] == 1) {
                    board[nx][ny] = 0;
                    cnt++;
                    q.offer(new Point(nx,ny));
                }
            }
        }
        max = Math.max(cnt,max);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 1) {
                    answer++; //그림의 갯수
                    board[i][j] = 0;
                    BFS(i,j);
                }
            }
        }
        bw.write(String.valueOf(answer)+"\n"+String.valueOf(max));
        bw.flush();
        bw.close();
    }
}
