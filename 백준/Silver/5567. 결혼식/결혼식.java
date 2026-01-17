import java.util.*;
import java.io.*;

public class Main {

    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch;

    public static void BFS(int curr) {
        for (int x : graph.get(curr)) {
            for (int v : graph.get(x)) {
                if (v == curr || graph.get(x).contains(v)) {
                    ch[v] = 1;
                    ch[x] = 1;
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        ch = new int[n+1];
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        StringTokenizer st;
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph.get(from).add(to);
            graph.get(to).add(from);
        }
        br.close();

        BFS(1);
        int answer = 0;
        for (int i = 2; i <= n; i++) {
            if (ch[i] > 0) answer++;
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();

    }
}
