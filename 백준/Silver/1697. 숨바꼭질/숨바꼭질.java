
import java.io.*;
import java.util.*;

public class Main {

    static int[] dis = {1,-1,2};
    static int[] ch;
    static Queue<Integer> q = new LinkedList<>();


    public int BFS(int n,int k) {
        if (n == k) return 0;
        ch = new int[100001];
        ch[n] = n;
        q.offer(n);
        int L = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int v = q.poll();
                for (int j = 0; j < 3; j++) {
                    int nx;
                    if (j == 2) nx = v * dis[j];
                    else nx = v + dis[j];
                    if (nx == k) return L+1;
                    if (nx >= 1 && nx <= 100000 && ch[nx] == 0) {
                        ch[nx] = 1;
                        q.offer(nx);
                    }
                }
            }
            L++;
        }
        return 0;
    }


    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        System.out.println(T.BFS(n,k));
    }
}
