
import java.io.*;
import java.util.*;

//svr2 스택 수열
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int currentNum = 1;
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            int v = Integer.parseInt(br.readLine());
            while(true) {
                if (!stack.isEmpty() && stack.peek() == v) {
                        stack.pop();
                        cnt++; sb.append("-" + "\n");
                        break;
                    } else {
                    if (currentNum <= n) {
                        stack.push(currentNum++);
                        sb.append("+" + "\n");
                    } else break;
                }
            }
        }

        if (n == cnt) {
            System.out.println(sb.toString().stripTrailing());
        } else System.out.println("NO");
    }
}