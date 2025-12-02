import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int answer = 0;

        int tmp = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            tmp = sc.nextInt();
            if (tmp != 0) {
                stack.push(tmp);
            } else {
                stack.pop();
            }
        }
        for (int x : stack) {
            answer += x;
        }
        System.out.println(answer);
    }
}
