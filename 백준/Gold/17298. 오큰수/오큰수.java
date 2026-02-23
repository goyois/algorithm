
import java.io.*;
import java.util.*;

//단조 스택 알고리즘 NGE
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[n];
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            arr[i] = x;
        }

        //NGE 의 경우 배열의 마지막 원소부터 시작
        //PGE 의 경우 베열의 첫번째 원소부터 시작
        stack.push(arr[n-1]); //마지막 원소를 스택에 넣는다.
        answer[n-1] = -1; //마지막 원소이므로 정답 배열에 -1
        for (int i = n-2; i >= 0; i--) { //arr[n-2] 원소부터 시작
            //stack top 이 진입하는 값보다 크면 오큰수 판정
            if (stack.peek() > arr[i]) answer[i] = stack.peek();

            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                //만약 stack top 보다 진입하는 값이 더 크면
                //stack top 이 진입하는 값보다 클 때까지 pop
                stack.pop();
            }
            //스택이 비었다면 -1
            //아니라면 정답 배열에 stack 의 top 기록
            if (stack.isEmpty()) answer[i] = -1;
            else answer[i] = stack.peek();

            //진입 값도 stack 에 넣어준다.
            stack.push(arr[i]);
        }

        for (int x : answer) {
            sb.append(x).append(" ");
        }
        System.out.println(sb);
    }
}
