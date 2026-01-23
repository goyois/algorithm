import java.io.*;
import java.util.*;

public class Main {

    static int w,h;
    static int[] dx = {1,0,-1,0}; //상하
    static int[] dy = {0,1,0,-1}; //좌우
    static char[][] board;
    static Queue<Point> q = new ArrayDeque<>();
    static Queue<Point> fire = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();

    static class Point{
        int x,y;

        Point(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    
    public static void BFS() {
        int time = 0;

        while (!q.isEmpty()) {
            time++;
            int fireLne = fire.size();
            for (int i = 0; i < fireLne; i++) {
                Point f = fire.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = f.x + dx[j];
                    int ny = f.y + dy[j];
                    if (nx >= 0 && nx < h && ny >= 0 && ny < w) {
                        if (board[nx][ny] == '.' || board[nx][ny] == '@') {
                            board[nx][ny] = '*';
                            fire.offer(new Point(nx,ny));
                        }
                    }
                }
            }


            int qLen = q.size();
            for (int i = 0; i < qLen; i++) {
                Point tmp = q.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = tmp.x + dx[j];
                    int ny = tmp.y + dy[j];
                    if (nx < 0 || nx >= h || ny < 0 || ny >= w) {
                        sb.append(time).append("\n");
                        return;
                    }

                    if (board[nx][ny] == '.') {
                        board[nx][ny] = '*';
                        q.offer(new Point(nx,ny));
                    }
                }
            }
        }
        sb.append("IMPOSSIBLE").append("\n");
    }
    

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        while (n--> 0){
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            board = new char[h][w];
            q.clear();
            fire.clear();

            for (int i = 0; i < h; i++) {
                String line = br.readLine();
                for (int j = 0; j < w; j++) {
                    board[i][j] = line.charAt(j);
                    if (board[i][j] == '@') q.offer(new Point(i,j));
                    if (board[i][j] == '*') fire.offer(new Point(i,j));
                }
            }
            
            BFS();
        }
        
        System.out.println(sb);
    }
}
