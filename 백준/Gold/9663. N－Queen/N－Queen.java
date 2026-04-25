
import java.io.*;
import java.util.*;

public class Main {

    static int[] arr;
    static int n;
    static int depth = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dfs(0);

        System.out.println(depth);
    }


    static void dfs(int d) {
        //모든 행에 퀸을 놓았으면 성공 케이스이므로 카운트
        if (d == n) {
            depth++;
            return;
        }

        //현재 행의 0번 열부터 n - 1 번 열까지 하나씩 놓는다
        for (int i = 0; i < n; i++) {
            //퀸 배치
            arr[d] = i;
            //놓은 위치 검사 진행
            if (check(d)) {
                dfs(d + 1); // 유효하면 다음 행으로 이동
            } // 아닐 경우 다음 i 로 백트래킹
        }
    }


    //퀸을 놓을 수 있는 자리인지 검사
    static boolean check(int col) {
        for (int i = 0; i < col; i++) {
            //같은 열 퀸 여부 검사
            if (arr[i] == arr[col]) {
                return false;
                //대각선 퀸 여부 검사
                //열의 차이와 행의 차이가 같다면 대각선에 위치한 것
            } else if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
                return false;
            }
        }
        return true;
    }
}
