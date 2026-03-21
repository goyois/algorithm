
import java.io.*;
import java.util.*;

public class Main {

    static int n,k;

    static class Point {
        int from,curr,count;
        public Point(int from, int curr, int count) {
            this.from = from;
            this.curr = curr;
            this.count = count;
        }
    }

    public static void bfs(int start) {
        int[] time = new int[100001];
        boolean[] visited = new boolean[100001];

        Queue<Point> q = new ArrayDeque<>();
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        q.offer(new Point(0,start,0));
        visited[start] = true;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++){
                Point tmp = q.poll();

                if (tmp.curr == k) {
                    //역추적
                    //정답 요소 넣기
                    stack.push(tmp.curr);

                    //given
                    //time[curr] 에 이전 값을 저장해둠
                    
                    //currNum 변수에 현재 값을 넣고
                    //time[currNum]의 값을 변수 x 에 할당한다.
                    //x 는 이전 값이고, 해당 값을 스택에 넣는다. (역순으로 꺼내기 위함)
                    //그리고 currNum 을 다음 이전 값을 찾기 위해 x 로 할당하여 그 다음 이전 값을 찾도록 한다.
                    int currNum = tmp.curr;
                    for (int j = 0; j < tmp.count; j++) {
                        int x = time[currNum];
                        stack.push(x);
                        currNum = x;
                    }
                    sb.append(tmp.count).append("\n");
                    while (!stack.isEmpty()) sb.append(stack.pop() + " ");
                    System.out.println(sb);
                    return;
                }

                int pos = 0;
                for (int j = 0; j < 3; j++) {
                    if (j == 0) pos = tmp.curr + 1;
                    else if (j == 1) pos = tmp.curr - 1;
                    else pos = tmp.curr * 2;

                    if (pos < 0 || pos > 100000) continue;

                    if (!visited[pos] && time[pos] == 0) {
                        visited[pos] = true;
                        time[pos] = tmp.curr;
                        q.offer(new Point(tmp.curr, pos,tmp.count + 1));
                    }
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); //start
        k = Integer.parseInt(st.nextToken()); //goal
        bfs(n);
    }
}
