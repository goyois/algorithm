import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        Stack<int[]> stack = new Stack<>();
        for (int i = 1; i <= n; i++) {
            int x = Integer.parseInt(st.nextToken());

            //스택이 비어있지않거나 peek 값이 x 보다 작다면 pop한다.
            //x 보다 작은 값은 어차피 수신을 못함
            //O(n2) 발생할 경우의 수를 제거
            while (!stack.isEmpty() && stack.peek()[0] < x) {
                stack.pop();
            }
            
            //스택이 비었다면 0
            if (stack.isEmpty()) sb.append(0).append(" ");
            //남아있으면 그게 수신가능한 탑
            else sb.append(stack.peek()[1]).append(" ");
            
            //x push
            stack.push(new int[]{x,i});
        }
        
        System.out.println(sb);
    }
}
