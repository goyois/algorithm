
import java.util.*;
import java.io.*;

public class Main {

    static int[] dx = {0, 0, 0, 0, 1, -1}; // 행 (n)
    static int[] dy = {1, -1, 0, 0, 0, 0}; // 열 (m)
    static int[] dz = {0, 0, 1, -1, 0, 0}; // 높이 (h)
    static int n,m,h;
    static int[][][] board,dis;
    static Queue<Point> q = new LinkedList<>();

    static class Point {
        int x,y,z;
        public Point(int z, int x, int y) {
            this.z = z;
            this.x = x;
            this.y = y;
        }
    }


    public static void BFS() {
        while (!q.isEmpty()) {
            Point tmp = q.poll();
            for (int i = 0; i < 6; i++) {
                int nz = tmp.z + dz[i];
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && nz >= 0 && nz < h && board[nz][nx][ny] == 0) {
                    board[nz][nx][ny] = 1;
                    dis[nz][nx][ny] = dis[tmp.z][tmp.x][tmp.y] + 1;
                    q.offer(new Point(nz,nx,ny));
                }
            }
        }
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken()); //열 가로
        n = Integer.parseInt(st.nextToken()); //행 세로
        h = Integer.parseInt(st.nextToken()); //면 

        board = new int[h][n][m]; 
        dis = new int[h][n][m];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    board[i][j][k] = Integer.parseInt(st.nextToken());
                    if (board[i][j][k] == 1) {
                        q.offer(new Point(i,j,k));

                    }
                }
            }
        }
        br.close();

        BFS();

        boolean flag = true;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (board[i][j][k] == 0) flag = false;
                }
            }
        }

        int answer = Integer.MIN_VALUE;
        if (flag) {
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < m; k++) {
                       answer = Math.max(answer,dis[i][j][k]);
                    }
                }
            }
            bw.write(String.valueOf(answer));
        } else bw.write(String.valueOf(-1));

        bw.flush();
        bw.close();

    }
}
