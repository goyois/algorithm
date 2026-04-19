
import java.io.*;
import java.util.*;

public class Main {

    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int[][] board;
    static int n,m,k;

    static class Point {
        int x,y,dist,broken;

        public Point(int x, int y, int dist, int broken) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.broken = broken;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) board[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
        }

        bfs();
    }

    public static void bfs() {
        boolean[][][] visited = new boolean[n][m][11];
        Queue<Point> q = new ArrayDeque<>();
        q.offer(new Point(0,0,1,0));

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Point tmp = q.poll();

                if (tmp.x == n - 1 && tmp.y == m - 1) {
                    System.out.println(tmp.dist);
                    return;
                }

                for (int j = 0; j < 4; j++) {
                    int nx = tmp.x + dx[j];
                    int ny = tmp.y + dy[j];

                    if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

                    if (board[nx][ny] == 0) {
                        if (!visited[nx][ny][tmp.broken]) {
                            visited[nx][ny][tmp.broken] = true;
                            q.offer(new Point(nx,ny,tmp.dist + 1, tmp.broken));
                        }
                    } else if (board[nx][ny] == 1) {
                        if (tmp.broken < k && !visited[nx][ny][tmp.broken + 1]) {
                            visited[nx][ny][tmp.broken + 1] = true;
                            q.offer(new Point(nx,ny,tmp.dist + 1,tmp.broken + 1));
                        }
                    }
                }
            }
        }
        if (q.isEmpty()) System.out.println(-1);
    }
}
