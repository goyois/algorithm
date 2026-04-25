
import java.io.*;
import java.util.*;

public class Main {

    static int L,C;
    static boolean[] ch;
    static char[] arr;
    static char[] pm;
    static StringBuilder sb = new StringBuilder();

    public static void dfs(int idx,int start) {
        if (idx == L) {
            if (check(pm)) {
                for (int i = 0; i < L; i++) {
                    sb.append(pm[i]);
                }
                sb.append("\n");
            }
        } else {
            for (int i = start; i < C; i++) {
                if (!ch[i]) {
                    pm[idx] = arr[i];
                    dfs(idx + 1,i + 1);
                    ch[i] = false;
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        pm = new char[L];
        ch = new boolean[C];

        String line = br.readLine().replace(" ","");
        arr = new char[C];

        for (int i = 0; i < C; i++) {
            arr[i] = line.charAt(i);
        }
        Arrays.sort(arr);

        dfs(0,0);
        System.out.println(sb);
    }

    public static boolean check(char[] pm) {
        boolean check = false;
        int cnt = 0;
        for (char c : pm) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                check = true;
            } else {
                cnt++;
            }
        }
        if (cnt < 2) check = false;
        return check;
    }
}
