
import java.io.*;
import java.util.*;


public class Main {

    static int n,m;
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;
    static boolean flag = false;


    public static void dfs(int depth,int n) {
        if (depth == 4) {
            flag = true;
            return;
        } else {
            visited[n] = true;
            for (int x : graph.get(n)) {
                if (!visited[x]) {
                    dfs(depth+1, x);
                    if (flag) return;
                }
            }
            visited[n] = false;
        }
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n+1];
        graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph.get(A).add(B);
            graph.get(B).add(A);
        }


        for (int i = 0; i < n; i++) {
            dfs(0,i);
        }
        if (flag) System.out.println(1);
        else System.out.println(0);
    }
}
