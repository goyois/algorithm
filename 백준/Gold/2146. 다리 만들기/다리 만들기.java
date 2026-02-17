
import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int[][] board,dis;
    static boolean[][] visited;
    static Queue<Point> q = new ArrayDeque<>();


    static class Point {
        int x,y,no;
        Point(int x, int y,int no) {
            this.x=x;
            this.y=y;
            this.no=no;
        }
    }


    //이동거리 bfs
    public static int bfs() {
        int min = 10000000;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Point tmp = q.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = tmp.x + dx[j];
                    int ny = tmp.y + dy[j];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                        //이동할 때 마다 객체에 출발지를 담고(tmp.no)
                        //board[nx][ny] 에 섬을 덮어씌운다.(어느 섬에서 출발한 객체가 board[nx][ny]까지 왔는지)
                        //아직 점유하지않은 바다일 경우 ?
                        if (board[nx][ny] == 0) {
                            board[nx][ny] = tmp.no;
                            visited[nx][ny] = true;
                            //별도의 이동 거리 행렬에 이동 횟수 표시
                            dis[nx][ny] = dis[tmp.x][tmp.y] + 1;
                            q.offer(new Point(nx, ny, tmp.no));
                        } else if (board[nx][ny] != tmp.no){
                            //이미 점유된 바다인 경우 2번 섬에서 출발한 객체와 3번 섬에서 출발한 객체가 만난 경우
                            //+ 반례에 따라 큐에 있는 모든 객체가 전부 시도해본 뒤 최솟값 갱신
                            //보통 1회차에 전부 갱신됨
                            min = Math.min(min,dis[tmp.x][tmp.y] + dis[nx][ny]);
                        }
                    }
                }
            }
        }
        return min;
    }





    //섬 이름 분류 메서드
    public static void islandNaming(int x,int y,int number) {
        board[x][y] = number;
        visited[x][y] = true;
        q.offer(new Point(x,y,number));
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                if (board[nx][ny] == 1 && !visited[nx][ny]) {
                    islandNaming(nx,ny,number);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        board = new int[n][n]; //맵
        dis = new int[n][n]; //이동 거리
        visited = new boolean[n][n]; // 방문 여부

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //섬을 먼저 독립적으로 분류시켜서 구별해야한다.
        //dfs 로 섬을 구분하여 넘버링한다.
        int number = 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1 && !visited[i][j]) {
                    islandNaming(i,j,number++);
                }
            }
        }
        System.out.println(bfs());
    }
}
