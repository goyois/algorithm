import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][n];
        
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                for (int k = 0; k < n; k++){
                    if (board[j][i] == 1 && board[i][k] == 1){
                        board[j][k] = 1;
                    }
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int[] x : board){
            for (int tmp : x){
                 sb.append(tmp+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}