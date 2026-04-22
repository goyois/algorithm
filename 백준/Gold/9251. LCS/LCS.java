
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine();
        String B = br.readLine();

        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        //공집합 표현을 위한 인덱스가 한줄 추가됨
        int[][] LCS = new int[A.length()+1][B.length()+1];

        //1부터 시작 (index 0 은 공집합이므로 0)
        for (int i = 1; i <= a.length; i++) {
            for (int j = 1; j <= b.length; j++) {
                //i-1 과 j-1 (대각선 위) 가 문자가 서로 같다면 그 값에 + 1 을 추가해줌  
                if (a[i-1] == b[j-1]) LCS[i][j] = LCS[i - 1][j - 1] + 1;
                //같지 않다면 i-1 과 j-1 의 값 중 큰 것으로 갱신
                else LCS[i][j] = Math.max(LCS[i - 1][j],LCS[i][j - 1]);
            }
        }
        System.out.println(LCS[a.length][b.length]);

    }
}
