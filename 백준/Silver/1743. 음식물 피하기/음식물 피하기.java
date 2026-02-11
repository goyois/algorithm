
import java.io.*;
import java.util.*;

public class Main {

    static int n,m;
    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int max = Integer.MIN_VALUE;

    static class Point {
        int x,y;

        Point(int x,int y) {
            this.x=x;
            this.y=y;
        }
    }


    public static int dfs(int x,int y) {
        visited[x][y] = true;
        int cnt = 1;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                if (!visited[nx][ny] && board[nx][ny] == 1) {
                    cnt += dfs(nx,ny);
                }
            }
        }
        return cnt;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); //행
        m = Integer.parseInt(st.nextToken()); //열
        int k = Integer.parseInt(st.nextToken()); //쓰레기 갯수

        board = new int[n][m];
        visited = new boolean[n][m];

        while (k-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            board[x-1][y-1] = 1; //쓰레기
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 1 && !visited[i][j]) {
                    max = Math.max(max,dfs(i,j));
                }
            }
        }
        System.out.println(max);
    }
}
