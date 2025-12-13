import java.io.*;
import java.util.*;

//풍선 터뜨리기
public class Main {

    static class Bl {
        int id;
        int input;

        public Bl(int id, int input) {
            this.id = id;
            this.input = input;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayDeque<Bl> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            deque.add(new Bl(i+1,Integer.parseInt(st.nextToken())));
        }

        StringBuilder sb = new StringBuilder();
        int tmp = 0;
        for (int i = 0; i < n; i++) {
            Bl bl = deque.peek();
            tmp = bl.input;
            sb.append(bl.id + " ");
            deque.poll();

            if (!deque.isEmpty()) {
                if (tmp > 0) {
                    while (tmp-- > 1) {
                        deque.offer(deque.poll());
                    }
                } else {
                    while (tmp++ < 0) {
                        deque.offerFirst(deque.pollLast());
                    }
                }
            }
    }
        System.out.println(sb.toString().stripTrailing());
    }
}
