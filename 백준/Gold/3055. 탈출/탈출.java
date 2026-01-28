import java.io.*;
import java.util.*;

public class Main {

    static int n,m;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static char[][] board;
    static boolean[][] visited;
    static Queue<Point> q = new LinkedList<>();
    static Queue<Point> wq = new LinkedList<>();


    static class Point{
        int x,y;
        Point(int x,int y) {
            this.x=x;
            this.y=y;
        }
    }


    public static void BFS() {
        int time = 0;
        visited = new boolean[n][m];

        while (!q.isEmpty()) {
            int wqSize = wq.size();
            for (int i = 0; i < wqSize; i++) {
                Point tmp = wq.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = tmp.x + dx[j];
                    int ny = tmp.y + dy[j];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] == '.') {
                        board[nx][ny] = '*';
                        wq.offer(new Point(nx,ny));
                    }
                }
            }

            time++;
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                Point tmp = q.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = tmp.x + dx[j];
                    int ny = tmp.y + dy[j];

                    if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                        if (board[nx][ny] == 'D') {
                            System.out.println(time);
                            return;
                        }

                        if (board[nx][ny] == '.' && !visited[nx][ny]) {
                            visited[nx][ny] = true;
                            q.offer(new Point(nx, ny));
                        }
                    }
                }
            }
        }
        if (q.isEmpty()) System.out.println("KAKTUS");
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new char[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = line.charAt(j);
                if (board[i][j] == 'S') q.offer(new Point(i,j));
                if (board[i][j] == '*') wq.offer(new Point(i,j));
            }
        }
        
        BFS();
    }
}
