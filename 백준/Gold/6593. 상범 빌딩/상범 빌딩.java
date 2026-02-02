import java.io.*;
import java.util.*;

public class Main {

    static int[] dz = {1,-1,0,0,0,0}; //상하
    static int[] dx = {0,0,1,-1,0,0}; //좌우
    static int[] dy = {0,0,0,0,1,-1}; //페이지
    static int L,R,C;
    static boolean[][][] visited;
    static char[][][] board;
    static Queue<Point> q = new LinkedList<>();
    
    static class Point {
        int z,x,y;
        Point(int z,int x,int y) {
            this.z=z;
            this.x=x;
            this.y=y;
        }
    }
    
    
    //시작점 #
    //갈 수 있는 곳 .
    //도착점 E
    public static void BFS() {
        int answer = 0;

        while (!q.isEmpty()) {
            //시작점
            answer++;
            int len = q.size();

            for (int i = 0; i < len; i++) {
                Point tmp = q.poll();
                for (int j = 0; j < 6; j++) {
                    int nz = tmp.z + dz[j];
                    int nx = tmp.x + dx[j];
                    int ny = tmp.y + dy[j];
                    if (nz >= 0 && nz < L && nx >= 0 && nx < R && ny >= 0 && ny < C && !visited[nz][nx][ny]) {
                        if (board[nz][nx][ny] == 'E'){
                            System.out.println("Escaped in " + answer + " minute(s).");
                            return;
                        } else if (board[nz][nx][ny] == '.') {
                            visited[nz][nx][ny] = true;
                            q.offer(new Point(nz, nx, ny));
                        }
                    }
                }
            }
        }
        if (q.isEmpty()) System.out.println("Trapped!");
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String line = br.readLine();
            if (line.isEmpty()) continue;

            StringTokenizer st = new StringTokenizer(line);
            L = Integer.parseInt(st.nextToken()); //층
            R = Integer.parseInt(st.nextToken()); //행
            C = Integer.parseInt(st.nextToken()); //열
            if (L == 0 && R == 0 && C == 0) break;
            
            q.clear();
            board = new char[L][R][C];
            visited = new boolean[L][R][C];

            for (int p = 0; p < L; p++) {
                for (int i = 0; i < R; i++) {
                    String cmd = br.readLine();
                    for (int j = 0; j < C; j++) {
                        board[p][i][j] = cmd.charAt(j);
                        if (cmd.charAt(j) == 'S') q.offer(new Point(p,i,j));
                    }
                }
                br.readLine();
            }
            
            BFS();
        }
    }
}
