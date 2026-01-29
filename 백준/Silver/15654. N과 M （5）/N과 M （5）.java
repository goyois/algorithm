
import java.io.*;
import java.util.*;

public class Main {

    static int n,m;
    static int[] pm,arr;
    static boolean[] ch;
    static StringBuilder sb = new StringBuilder();

    public static void DFS(int L) {
        if (L == m) { // 인덱스 위치
            for (int x : pm) {
                sb.append(x).append(" ");
            }
            sb.append("\n");
        } else {
            for (int i = 1; i <= n; i++) {
                if (!ch[i]) { //체크 배열로 첫 인덱스의 원소 체크
                    ch[i] = true;
                    pm[L] = arr[i];
                    DFS(L+1); //첫 인덱스 이후 체크 안된 원소를 DFS 돌며 체크 처리하며 L == m 쪽에서 리턴
                    ch[i] = false; //스택프레임에서 리턴하며 쌓여있던 ch 배열의 체크 해제
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        pm = new int[m];
        arr = new int[n+1];
        ch = new boolean[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        DFS(0);
        System.out.println(sb);
    }
}
