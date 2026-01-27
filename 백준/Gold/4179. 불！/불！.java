
import java.util.*;
import java.io.*;

public class Main {

    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int n,m;
    static char[][] board;
    static Queue<Point> q = new LinkedList<>();
    static Queue<Point> fq = new LinkedList<>();


    static class Point{
        int x,y;
        Point(int x, int y) {
            this.x=x;
            this.y=y;
        }
    }


    public static void BFS() {
        int time = 0;
        boolean[][] visited = new boolean[n][m];
        //1.지훈이의 이동가능 좌표를 담은 큐가 빌때까지 반복한다. (몇초가 걸리는지?
        //  즉 레벨 탐색 문제 유형이므로 불과 지훈이의 속도를 동기화시킨다.
        //  불과 지훈이는 1초당 상하좌우 1칸씩만 이동이 가능함.)
        while (!q.isEmpty()) {
            //2.회차별(첫 회차 또는 불+지훈의 이동처리 순회 완료 시점)시간을 누적한다. +1초
            time++;

            //3.불을 먼저 번지게하고 불이 번진 뒤 지훈이의 이동가능한 범위를 확인한다.
            int fireLen = fq.size();
            for (int i = 0; i < fireLen; i++) {
                Point tmp = fq.poll();
                for (int j = 0; j < 4; j++) {
                    int fx = tmp.x + dx[j];
                    int fy = tmp.y + dy[j];
                    if (fx >= 0 && fx < n && fy >= 0 && fy < m && board[fx][fy] == '.') {
                        board[fx][fy] = 'F';
                        fq.offer(new Point(fx, fy));
                    }
                }
            }

            //4.방문 배열을 만들어서 지훈이가 이동한 지점만 체크한다.(다시 되돌아가지않도록 체크하는 용도)
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                Point tmp = q.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = tmp.x + dx[j];
                    int ny = tmp.y + dy[j];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
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
        //[출력 조건]
        // y:만약 지훈이가 현재 위치에서부터 구해진 다음 지점의 좌표가 입력 범위를 넘어서면
        //   누적된 시간을 출력하고 종료한다.
        // n:반복문이 종료된것은 더이상 지훈이가 움직일 수 있는 좌표가 없다는 것이므로
        //   "IMPOSSIBLE" 출력하고 종료한다.
        if (q.isEmpty())System.out.println("IMPOSSIBLE");
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new char[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = line.charAt(j);
                if (board[i][j] == 'J') q.offer(new Point(i,j));
                if (board[i][j] == 'F') fq.offer(new Point(i,j));
            }
        }
        BFS();
    }
}
