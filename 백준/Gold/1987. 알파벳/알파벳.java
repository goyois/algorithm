
import java.io.*;
import java.util.*;

public class Main {
    
    static int r,c;
    static boolean[] visited = new boolean[26];
    static char[][] board;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int max = 0;

    public static void dfs(int x,int y,int  depth) {
        max = Math.max(max,depth);

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < r && ny >= 0 && ny < c) {
                int idx = board[nx][ny] - 'A';
                if (!visited[idx]) {
                    visited[idx] = true;
                    dfs(nx,ny,depth+1);
                    visited[idx] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        board = new char[r][c];

        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                board[i][j] = line.charAt(j);
            }
        }
        int firstIdx = board[0][0] - 'A';
        visited[firstIdx] = true;

        dfs(0,0,1);

        System.out.println(max);
    }
}