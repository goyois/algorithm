
import java.io.*;
import java.util.*;

public class Main {

    static int n,m,a,b;
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] ch;
    static boolean flag = false;


    public static void dfs(int depth,int x) {
        if (x == b) {
            flag = true;
            System.out.println(depth);
            return;
        } else {
            ch[x] = true;
            for (int next : graph.get(x)) {
                if (!ch[next]) {
                    dfs(depth+1,next);
                }
            }
            ch[x] = false;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(br.readLine());

        ch = new boolean[n+1];
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(p).add(c);
            graph.get(c).add(p);
        }
        dfs(0,a);
        if (!flag) System.out.println(-1);
    }
}
