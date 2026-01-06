import java.io.*;
import java.util.*;

public class Main {

    static class Point{
        int x,y;

        Point(int x,int y) {
            this.x=x;
            this.y=y;
        }
    }

    static int[] dx = {-1,0,1,0}; //가로
    static int[] dy = {0,1,0,-1}; //세로
    static int n,m; //열,행
    static int[][] board,dis; //입력 배열, 날수입력 배열
    static Queue<Point> q = new LinkedList<>();


    public void BFS() {
        while (!q.isEmpty()) {
            Point tmp = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = tmp.x+dx[i];
                int ny = tmp.y+dy[i];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && board[nx][ny] == 0) {
                    board[nx][ny] = 1;
                    q.offer(new Point(nx,ny));
                    dis[nx][ny] = dis[tmp.x][tmp.y]+1;
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); //열
        m = Integer.parseInt(st.nextToken()); //행
        board = new int[m][n];
        dis = new int[m][n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 1) q.offer(new Point(i,j));
            }
        }
        T.BFS();
        boolean flag = true;
        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) flag = false;
            }
        }
        
        if (flag) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    answer = Math.max(dis[i][j],answer);
                }
            }
            System.out.println(answer);
        } else System.out.println(-1);
    }
}