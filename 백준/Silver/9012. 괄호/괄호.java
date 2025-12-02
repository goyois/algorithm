import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }

        for (int i = 0; i < arr.length; i++) {
            Stack<Character> stack = new Stack<>();
            String answer = "YES";
            for (char c : arr[i].toCharArray()) {
                if (c == '(') {
                    stack.push(c);
                } else {
                    if (stack.isEmpty()){
                        answer = "NO";
                        break;
                    }
                    stack.pop();
                }
            }
            if (!stack.isEmpty()) answer = "NO";
            System.out.println(answer);
        }
    }
}
