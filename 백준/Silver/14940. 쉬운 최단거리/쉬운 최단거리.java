
import java.util.*;

public class Main {

    static class Point {
        int x,y;

        Point(int x,int y) {
            this.x=x;
            this.y=y;
        }
    }


    static int n,m;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] board,dis;
    static Queue<Point> queue = new LinkedList<>();

    public void BFS() {
        while (!queue.isEmpty()) {
            Point tmp = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = tmp.x+dx[i];
                int ny = tmp.y+dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] == 1) {
                    board[nx][ny] = 0;
                    queue.offer(new Point(nx, ny));
                    dis[nx][ny] = dis[tmp.x][tmp.y] + 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        board = new int[n][m];
        dis = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = sc.nextInt();
                if (board[i][j] == 2){
                    queue.offer(new Point(i,j));
                } else if (board[i][j] == 0) {
                    dis[i][j] = 0;
                } else {
                    dis[i][j] = -1;
                }
            }
        }
        T.BFS();
        StringBuilder sb = new StringBuilder();
        for (int[] x : dis) {
            for (int nx : x) {
                sb.append(nx+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
