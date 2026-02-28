
import java.io.*;
import java.util.*;

//스도쿠
public class Main {

    static int[][] board = new int[9][9]; //보드판 배열
    static StringBuilder sb = new StringBuilder();


    //x = 행 L = 현재 몇번째 값을 채우고 있는지 위치
    public static void sudoku(int row,int col) {
        //다음 행으로 넘어감
        if (col == 9) {
            sudoku(row + 1,0);
            return;
        }

        //8번행까지 끝났다면?
        if (row == 9) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(board[i][j]).append(" ");
                }
                sb.append("\n");
            }
            System.out.println(sb);
            System.exit(0);
        }


        //숫자가 0이라면 조건식을 통해 들어갈 숫자를 결정함
        if (board[row][col] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (check(row, col, i)) {
                    board[row][col] = i;
                    sudoku(row,col + 1);
                }
            }
            board[row][col] = 0;
        } else {
            //숫자가 있는 경우
            sudoku(row,col + 1);
        }

    }

    public static boolean check(int row,int col, int v) {

        //같은 열과 행에 중복되는 숫자가 있는지?
        for (int i = 0; i < 9; i++) if (board[i][col] == v) return false;
        for (int i = 0; i < 9; i++) if (board[row][i] == v) return false;

        //value 가 속한 3x3 범위 행,열의 첫 위치
        int set_row = (row / 3) * 3;
        int set_col = (col / 3) * 3;

        //3x3 범위 내에서의 검증
        for (int i = set_row; i < set_row + 3; i++) {
            for (int j = set_col; j < set_col + 3; j++) if (board[i][j] == v) return false;
        }

        //위 조건식 전부 만족안되는 경우 true 리턴
        return true;
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        sudoku(0,0);
    }
}
