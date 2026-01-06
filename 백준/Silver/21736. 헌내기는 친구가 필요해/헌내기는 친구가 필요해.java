import java.util.*;
import java.io.*;

public class Main {

    static class Point{
        int x,y;

        Point(int x, int y) {
            this.x=x;
            this.y=y;
        }
    }

    //12 3 6 9 방향 순서
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int n,m;
    static char[][] board;
    static Queue<Point> q = new LinkedList<>();
    static int answer = 0;

    public void BFS() {
        while (!q.isEmpty()) {
            Point tmp = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = tmp.x+dx[i];
                int ny = tmp.y+dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] == 'O') {
                    board[nx][ny] = 'X';
                    q.offer(new Point(nx,ny));
                } else if (nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] == 'P') {
                    answer++;
                    board[nx][ny] = 'X';
                    q.offer(new Point(nx,ny));
                }
            }
        }
    }



    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new char[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 0; j < m; j++) {
                board[i][j] = line.charAt(j);
                if (board[i][j] == 'I') q.offer(new Point(i,j));
            }
        }

        T.BFS();
        if (answer == 0) {
            bw.write("TT");
            bw.flush();
            bw.close();
        } else {
            bw.write(String.valueOf(answer));
            bw.flush();
            bw.close();
        }
    }
}
