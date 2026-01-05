import java.util.*;

public class Main {

    class Point {
        int x,y;

        Point(int x, int y) {
            this.x=x;
            this.y=y;
        }
    }


    static int n,m;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] board,visit;
    static int answer = 0;


    public void BFS(int x,int y) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x,y));

        board[x][y] = 0;
        visit[x][y] = 1;

        while (!q.isEmpty()) {
            Point tmp = q.poll();

            for (int i = 0; i < 4; i++){
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];

                if (nx >= 0 && nx < n &&
                    ny >= 0 && ny < m && board[nx][ny] == 1) {
                    board[nx][ny] = 0;
                    visit[nx][ny] = visit[tmp.x][tmp.y]+1;
                    q.offer(new Point(nx,ny));
                }
            }
        }
    }


    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m =sc.nextInt();
        board = new int[n][m];
        visit = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = sc.next();
            for (int j = 0; j < m; j++) {
                board[i][j] = line.charAt(j) - '0';
            }
        }

        T.BFS(0,0);
        
        if (visit[n-1][m-1] > 0) {
            System.out.println(visit[n-1][m-1]);
        } else {
            System.out.println(-1);
        }
    }
}
