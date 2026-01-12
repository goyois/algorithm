
import java.io.*;
import java.util.*;

public class Main {


    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int n;
    static boolean[][] visited;



    private void DFS(int x, int y,char curr,char[][] board) {
        visited[x][y] = true;

        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny]) {
                if (board[nx][ny] == curr) {
                    DFS(nx,ny,curr,board);
                }
            }
        }
    }




    public static void main(String[] args) throws IOException {
        Main M = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        char[][] boardNom = new char[n][n]; //일반인 배열
        char[][] boardColorBlind = new char[n][n]; //적록색약자 배열


        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                char c = line.charAt(j);
                boardNom[i][j] = c;
                //적록색약 배열은 G,R = R 로 통합
                if (c == 'G' || c == 'R') boardColorBlind[i][j] = 'R';
            }
        }


        //일반인 배열 순회
        int nomCnt = 0;
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    nomCnt++;
                    M.DFS(i,j,boardNom[i][j],boardNom);
                }
            }
        }

        //적록색약자 배열 순회
        int cbCnt = 0;
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    cbCnt++;
                    M.DFS(i,j,boardColorBlind[i][j],boardColorBlind);
                }
            }
        }


        StringBuilder sb = new StringBuilder();
        sb.append(nomCnt+" "+ cbCnt);
        System.out.println(sb);
    }
}
