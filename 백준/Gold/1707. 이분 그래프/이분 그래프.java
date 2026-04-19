
import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<ArrayList<Integer>> graph;
    static boolean flag;
    static int[] colors;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int vex = Integer.parseInt(st.nextToken());
            int edge = Integer.parseInt(st.nextToken());

            graph = new ArrayList<>();
            for (int i = 0; i <= vex; i++) graph.add(new ArrayList<>());
            colors = new int[vex+1];
            flag = true;

            for (int i = 0; i < edge; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            for (int i = 1; i <= vex; i++) {
                if (colors[i] == 0) dfs(i,1);
            }

            System.out.println(flag ? "YES" : "NO");
        }
    }

    public static void dfs(int start,int color) {
        colors[start] = color;

        for (int next : graph.get(start)) {
            if (colors[next] == colors[start]) {
                flag = false;
                return;
            }

            if (colors[next] == 0) {
                dfs(next,3-color);
            }
        }
    }
}
