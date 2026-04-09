
import java.io.*;
import java.util.*;

//말이 되고픈 원숭이
public class Main {

    //상,하.좌.우.퀸의 방향
    static int[] dx = {1,-1,0,0,1,2,2,1,-2,-1,-2,-1};
    static int[] dy = {0,0,1,-1,2,1,-1,-2,-1,-2,1,2};
    static int[][] board;
    static boolean[][][] visited;
    static int k,w,h;

    static class Position {
        int x,y,q,dist;
        public Position(int x, int y, int q, int dist) {
            this.x = x;
            this.y = y;
            this.q = q;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken()); //열
        h = Integer.parseInt(st.nextToken()); //행
        board = new int[h][w];
        visited = new boolean[h][w][k+1];
        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bfs();
    }


    public static void bfs() {
        Queue<Position> q = new ArrayDeque<>();
        visited[0][0][0] = true;
        q.offer(new Position(0,0,0,0));

        if (w == 1 && h == 1) {
            System.out.println(0);
            return;
        }

        while (!q.isEmpty()) {
            Position pos = q.poll();

            if (pos.x == h - 1 && pos.y == w - 1) {
                System.out.println(pos.dist);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = pos.x + dx[i];
                int ny = pos.y + dy[i];
                if (isCheck(nx, ny) && !visited[nx][ny][pos.q]) {
                    visited[nx][ny][pos.q] = true;
                    q.offer(new Position(nx,ny,pos.q,pos.dist + 1));
                }
            }

            if (pos.q < k) {
                for (int j = 4; j < 12; j++) {
                    int nx = pos.x + dx[j];
                    int ny = pos.y + dy[j];
                    if (isCheck(nx, ny) && !visited[nx][ny][pos.q + 1]) {
                        visited[nx][ny][pos.q + 1] = true;
                        q.offer(new Position(nx,ny,pos.q + 1,pos.dist + 1));
                    }
                }
            }
        }
        System.out.println(-1);
    }

    public static boolean isCheck(int x,int y) {
        boolean check = true;
        if (x < 0 || x >= h || y < 0 || y >= w || board[x][y] == 1) check = false;
        return check;
    }
}
