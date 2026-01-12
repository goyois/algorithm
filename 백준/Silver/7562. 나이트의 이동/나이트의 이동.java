import java.io.*;
import java.util.*;

public class Main {

    static int n,ex,ey;
    static int[] dx = {1,2,2,1,-1,-2,-2,-1};
    static int[] dy = {2,1,-1,-2,-2,-1,1,2};
    static int[][] board,dis;
    static Queue<Point> q = new ArrayDeque<>();


    static class Point{
        int x,y;
        Point(int x, int y) {
            this.x=x;
            this.y=y;
        }
    }

    public void BFS() {
        while (!q.isEmpty()) {
            Point tmp = q.poll();
            board[tmp.x][tmp.y] = 1;

            for (int i = 0; i < 8; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 0) {
                    board[nx][ny] = 1;
                    q.offer(new Point(nx,ny));
                    dis[nx][ny] = dis[tmp.x][tmp.y]+1;
                }
            }

        }
    }

    public static void main(String[] args) throws IOException {
        Main M = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            n = Integer.parseInt(br.readLine());
            board = new int[n][n];
            dis = new int[n][n];

            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                if (i == 0) {
                    q.offer(new Point(start, end));
                } else ex = start; ey = end;
            }
            M.BFS();
            sb.append(dis[ex][ey]).append("\n");
        }
        System.out.println(sb);
    }
}