import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[] dx = {0,1,0,-1}; //가로 행
    static int[] dy = {1,0,-1,0}; //세로 열
    static int[][] board;
    static int[] dis; //순회한 결과를 담는 변수 / 인덱스: 동, 값: 호수
    static int unit,no = 1; //동,호수 카운트 변수

    public void DFS(int x,int y, int[][] board) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 1) {
                board[nx][ny] = 0;
                no++;
                DFS(nx,ny,board);
            }
        }
    }

    public void solution(int[][] board) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    unit++;
                    board[i][j] = 0;
                    DFS(i,j,board);
                    dis[unit] = no;
                    no = 1;
                }
            }
        }
    }



    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        board = new int[n][n];
        dis = new int[n*n];
        for (int i = 0; i < n; i++){
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }


        T.solution(board);

        StringBuilder sb = new StringBuilder();
        sb.append(unit).append("\n");

        Arrays.sort(dis);
        //데이터 출력
        for (int c : dis) {
            if (c > 0) sb.append(c).append("\n");
        }
        System.out.println(sb);
    }
}
