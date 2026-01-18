
import java.io.*;
import java.util.*;

public class Main {

    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] board;
    static ArrayList<Integer> counts;
    static int n,m,k;
    static int answer = 0;

    
    static class Point {
        int x,y;

        Point(int x,int y) {
            this.x=x;
            this.y=y;
        }

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        m = Integer.parseInt(st.nextToken()); //행
        n = Integer.parseInt(st.nextToken()); //열
        k = Integer.parseInt(st.nextToken()); //박스 갯수

        board = new int[m][n];
        counts = new ArrayList<>();

        while (k-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for (int i = y1; i < y2; i++) {
                for (int j = x1; j < x2; j++) {
                    board[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    board[i][j] = 1;
                    answer++;
                    counts.add(BFS(i,j));
                }
            }
        }
        Collections.sort(counts);

        sb.append(answer).append("\n");
        for (int x : counts) sb.append(x+" ");
        System.out.println(sb);
    }

    public static int BFS(int x,int y) {
        Queue<Point> q = new ArrayDeque<>();
        int cnt = 0;
        q.offer(new Point(x,y));
        while (!q.isEmpty()) {
            Point tmp = q.poll();
            cnt++;
            for (int i = 0; i < 4; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && board[nx][ny] == 0) {
                    board[nx][ny] = 1;
                    q.offer(new Point(nx,ny));
                }
            }
        }
        return cnt;
    }
}
