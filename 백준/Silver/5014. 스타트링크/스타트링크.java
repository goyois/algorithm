
import java.io.*;
import java.util.*;

public class Main {

    static int F,S,G,U,D;
    static int[] ch;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void BFS(int s,int[] dx) throws IOException {
        Queue<Integer> q = new ArrayDeque<>();
        ch = new int[F+1];
        q.offer(s);
        int L = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                for (int j = 0; j < 2; j++) {
                    int tmp = cur + dx[j];
                    if (tmp == G){
                        bw.write(String.valueOf(L+1));
                        bw.flush();
                        bw.close();
                        return;
                    }

                    if (tmp >= 1 && tmp <= F && ch[tmp] == 0) {
                        ch[tmp] = 1;
                        q.offer(tmp);
                    }
                }
            }
            L++;
        }
        bw.write("use the stairs");
        bw.flush();
        bw.close();
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken()); // 총 F층의 건물
        S = Integer.parseInt(st.nextToken()); // 현재 위치한 층
        G = Integer.parseInt(st.nextToken()); // 가려는 층
        U = Integer.parseInt(st.nextToken()); // 위로 U번 올라갈 수 있다.
        D = Integer.parseInt(st.nextToken()); // 아래로 D번 내려갈 수 있다.
        
        if (S==G){
            System.out.println(0);
            System.exit(0);
        }
      
        int[] dx = new int[2];
        dx[0] = U;
        dx[1] = -D;

        BFS(S,dx);
    }
}
