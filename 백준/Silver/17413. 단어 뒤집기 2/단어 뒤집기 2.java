
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        boolean flag = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            //< 가 나오면 flag = true 해주고 괄호안에 있는 문자를 담는다
            //괄호 처리
            if (c == '<') {
                flag = true;
                while (!stack.isEmpty()) sb.append(stack.pop());
                sb.append(c);
            } else if (c == '>') {
                flag = false;
                sb.append(c);
            } else if (flag) {
                sb.append(s.charAt(i));
            } else if (!flag) {
                if (c == ' ') {
                    while (!stack.isEmpty()) sb.append(stack.pop());
                    sb.append(c);
                } else stack.push(c);
            }
        }

        while (!stack.isEmpty()) sb.append(stack.pop());

        System.out.println(sb);
    }
}