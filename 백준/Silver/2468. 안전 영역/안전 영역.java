import java.io.*;
import java.util.*;

public class Main {

    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int n;
    static int[][] board;
    static boolean[][] visited;
    
    
    
    public static void DFS(int h, int x, int y){
        visited[x][y] = true;
        for (int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n){
                if(board[nx][ny] > h && !visited[nx][ny]){
                    DFS(h,nx,ny);
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());

        board = new int[n][n];
        for (int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int max = 1;
        for (int h = 0; h <= 100; h++){
            visited = new boolean[n][n];
            int cnt = 0;
            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){
                    if (board[i][j] > h && !visited[i][j]){
                        cnt++;
                        DFS(h,i,j);
                    }               
                }
            }
            max = Math.max(max,cnt);
        } 
        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }
}