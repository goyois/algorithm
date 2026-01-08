
import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[] dx = {0,1,0,-1}; //가로 행
    static int[] dy = {1,0,-1,0}; //세로 열
    static int[][] board;

    public static int DFS(int x,int y) {
        int count = 1;
        board[x][y] = 0;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 1) {
                count += DFS(nx,ny);
            }
        }
        return count;
    }

    public void solution(List<Integer> list) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    list.add(DFS(i,j));
                }
            }
        }
    }

    
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        
        for (int i = 0; i < n; i++){
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = line.charAt(j) - '0';
            }
        }
        
        List<Integer> list = new ArrayList<>();

        T.solution(list);

        StringBuilder sb = new StringBuilder();
        Collections.sort(list);
        
        sb.append(list.size()).append("\n");
        //데이터 출력
        for (int c : list) {
            sb.append(c).append("\n");
        }
        System.out.println(sb);
    }
}
