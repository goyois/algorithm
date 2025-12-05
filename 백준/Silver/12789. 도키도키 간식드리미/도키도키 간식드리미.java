import java.util.*;

//도키도키 간식드리미
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }


        Stack<Integer> stack = new Stack<>();
        String answer = "Nice";
        int tmp = 0;
        int cnt = 1;

        for (int i = 0; i < n; i++) {
            if (arr[i] != cnt) {
                if (!stack.isEmpty() && cnt == stack.peek()) {
                    cnt++;
                    i--;
                    stack.pop();
                } else {
                    stack.push(arr[i]);
                }
            } else {
                cnt++;
            }
        }

        while(!stack.isEmpty()){
            int v = stack.pop();
            if (v == cnt) {
                cnt++;
            } else {
                answer = "Sad";
                break;
            }
        }
        System.out.println(answer);
    }
}
