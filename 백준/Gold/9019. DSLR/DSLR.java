
import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder answer = new StringBuilder();

    static class Register {
        int curr;
        String cmd;
        public Register(int curr, String cmd) {
            this.curr = curr;
            this.cmd = cmd;
        }
    }

    public static void bfs(int start,int end) {
        Queue<Register> q = new ArrayDeque<>();
        q.offer(new Register(start,""));
        boolean[] visited = new boolean[10000];
        visited[start] = true;
      
        while (!q.isEmpty()) {
            Register x = q.poll();
            for (int i = 0; i < 4; i++) {
                Register nx = new Register(0,x.cmd);

                if (i == 0) {
                    if (x.curr * 2 > 9999) nx.curr = (x.curr * 2) % 10000;
                    else nx.curr = x.curr * 2;
                    nx.cmd += "D";
                } else if (i == 1) {
                    if (x.curr == 0) nx.curr = 9999;
                    else nx.curr = x.curr - 1;
                    nx.cmd += "S";
                } else if (i == 2) {
                    nx.curr = (x.curr % 1000) * 10 + (x.curr / 1000);
                    nx.cmd += "L";
                } else {
                    nx.curr = (x.curr % 10) * 1000 + (x.curr / 10);
                    nx.cmd += "R";
                }

                if (nx.curr == end) {
                    answer.append(nx.cmd).append("\n");
                    return;
                }

                if (!visited[nx.curr]) {
                    visited[nx.curr] = true;
                    q.offer(new Register(nx.curr,nx.cmd));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bfs(a,b);
        }

        System.out.println(answer);
    }
}
