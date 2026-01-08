
import java.util.*;
import java.io.*;

public class Main {

    static int n,m,z;
    static int[] dx = {0,1,0,-1}; //가로 : 행
    static int[] dy = {1,0,-1,0}; //세로 : 열
    static int answer = 0;


    public void DFS(int x,int y,int[][] board) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < m && ny >= 0 && ny < n && board[nx][ny] == 1) {
                board[nx][ny] = 0;
                DFS(nx,ny,board);
            }
        }
    }

    public void solution(int[][] board) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    answer++;
                    board[i][j] = 0;
                    DFS(i,j,board);
                }
            }
        }
    }




    public static void main(String[] args) throws IOException {
        Main M = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int T =Integer.parseInt(st.nextToken());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); //열
            m = Integer.parseInt(st.nextToken()); //행
            z = Integer.parseInt(st.nextToken());

            int[][] board = new int[m][n];
            for (int i = 0; i < z; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                board[y][x] = 1;
            }

            M.solution(board);

            sb.append(answer).append("\n");
            answer = 0;
        }
        System.out.println(sb);
    }
}
