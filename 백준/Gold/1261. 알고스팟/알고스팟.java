
import java.io.*;
import java.util.*;

public class Main {

    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int[][] board;
    static int n,m;


    static class Pos {
        int x,y,dist;

        public Pos(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); //4
        m = Integer.parseInt(st.nextToken()); //2
        board = new int[m][n];
        for (int i = 0; i < m; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }
        bfs();
    }


    public static void bfs() {
        Deque<Pos> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[m][n];
        q.offer(new Pos(0, 0, 0));


        while (!q.isEmpty()) {

            int size = q.size();

            for (int i = 0; i < size; i++) {
                Pos tmp = q.poll();

                visited[tmp.x][tmp.y] = true;

                if (tmp.x == m - 1 && tmp.y == n - 1) {
                    System.out.println(tmp.dist);
                    return;
                }

                for (int j = 0; j < 4; j++) {
                    int nx = tmp.x + dx[j];
                    int ny = tmp.y + dy[j];

                    if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;

                    if (!visited[nx][ny]) {
                        visited[nx][ny] = true;
                        if (board[nx][ny] == 0) {
                            q.offerFirst(new Pos(nx, ny, tmp.dist));
                        } else {
                            q.offerLast(new Pos(nx, ny, tmp.dist + 1));
                        }
                    }
                }
            }
        }
        if (q.isEmpty()) System.out.println(0);
    }
}
