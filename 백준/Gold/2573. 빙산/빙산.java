
import java.io.*;
import java.util.*;

public class Main {

    static int n,m;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int[][] board;
    static boolean[][] visited;
    static Queue<Point> q = new ArrayDeque<>();

    static class Point {
        int x,y,cost;

        Point(int x, int y,int cost) {
            this.x=x;
            this.y=y;
            this.cost=cost;
        }
    }



    //빙산 처리
    public static void bfs() {
        int L = 0;
        while (!q.isEmpty()) {
            L++;
            visited = new boolean[n][m];
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Point tmp = q.poll();
                int cnt = 0; //빈칸 갯수
                for (int j = 0; j < 4; j++) {
                    int nx = tmp.x + dx[j];
                    int ny = tmp.y + dy[j];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                        if (board[nx][ny] == 0) {
                            cnt++;
                        }
                    }
                }
                //아직 높이가 1이상이라면 다시 큐에 넣어준다.
                if (board[tmp.x][tmp.y] > 0) q.offer(new Point(tmp.x,tmp.y,cnt));
            }

            for (Point tmp : q) {
                //높이가 1이상의 빙산일 때 동서남북 빈칸 갯수만큼 빼준다.
                int newCost = board[tmp.x][tmp.y] - tmp.cost;
                board[tmp.x][tmp.y] = newCost;
                if (board[tmp.x][tmp.y] <= 0) board[tmp.x][tmp.y] = 0;
                else if (board[tmp.x][tmp.y] > 0) visited[tmp.x][tmp.y] = true;
            }

            int answer = solution(visited);
            if (answer >= 2) {
                System.out.println(L);
                return;
            }
        }

        System.out.println(0);
    }



    //분리된 빙산의 갯수 카운트
    public static void ch(int x,int y,boolean[][] visited) {
        Queue<Point> cntQ = new ArrayDeque<>();
        cntQ.offer(new Point(x,y,0));

        while (!cntQ.isEmpty()) {
            int len = cntQ.size();
            for (int i = 0; i < len; i++) {
                Point tmp = cntQ.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = tmp.x + dx[j];
                    int ny = tmp.y + dy[j];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m  && visited[nx][ny]) {
                        visited[nx][ny] = false;
                        cntQ.offer(new Point(nx,ny,0));
                    }
                }
            }
        }
    }


    public static int solution(boolean[][] visited) {
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] > 0 && visited[i][j]) {
                    ch(i,j,visited);
                    answer++;
                }
            }
        }
        return answer;
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] > 0) {
                    q.offer(new Point(i, j, 0));
                }
            }
        }
        bfs();
    }
}
