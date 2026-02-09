import java.io.*;
import java.util.*;

public class Main {

    static int answer;
    static int[] arr;
    static boolean[] ch;
    static boolean[] finished;


    public static void dfs(int curr) {
        ch[curr] = true;
        int next = arr[curr];

        if (!ch[next]) {
            dfs(next);
        } else {
            if (!finished[next]) {
                answer++;
                for (int i = next; i != curr; i = arr[i]) {
                    // i = 4, 4 != 6 ? true, i = arr[4] = 7;
                    // i = 7, 7 != 6 ? true, i = arr[7] = 6;
                    // i = 6, 6 == 6 ? false(종료 조건), i = arr[6] = 4;
                    //종료 조건에 의해 answer++ 이후 종료
                    answer++;
                }
            }
        }
        //스택에서 전부 리턴될 때 true 처리
        finished[curr] = true;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        while (n--> 0){
            int m = Integer.parseInt(br.readLine());
            arr = new int[m+1];
            ch = new boolean[m+1];
            finished = new boolean[m+1];
            answer = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= m; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= m; i++) {
                if (!ch[i]) dfs(i);
            }
            System.out.println(m - answer);

        }
    }
}
