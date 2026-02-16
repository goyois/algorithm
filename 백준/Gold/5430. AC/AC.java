
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            Deque<Integer> deq = new LinkedList<>();
            String cmd = br.readLine(); //명령어
            int arrLen = Integer.parseInt(br.readLine()); //배열 길이
            String numList = br.readLine(); //배열 원소 입력

            StringBuilder num = new StringBuilder();
            for (int i = 0; i < numList.length(); i++) {
                if (Character.isDigit(numList.charAt(i))) {
                    num.append(numList.charAt(i));
                }
                if (numList.charAt(i) == ',' || numList.charAt(i) == ']') {
                    if (num.length() > 0) {
                        deq.offer(Integer.parseInt(num.toString()));
                        num.setLength(0);
                    }
                }
            }

            //R : 순서 뒤집기
            //D : 첫번째 수 버리기
            //배열이 비어있는데 D 를 하는 경우 error 출력
            boolean isFlag = true; // 정방향
            boolean isContinue = false;
            //명령어 실행
            for (char c : cmd.toCharArray()) {
                //R 을 통해 현재 출력되어야하는 상태만 체크
                if (c == 'R') {
                    isFlag = !isFlag; //현재 상태의 반대
                } else if (c == 'D') {
                    if (deq.isEmpty()) {
                        sb.append("error").append("\n");
                        isContinue = !isContinue; //D 인데 빈 덱인 경우를 체크
                        break;
                    }
                    if (isFlag) deq.pollFirst(); //정방향인 경우 맨 앞의 값 버림
                    else deq.pollLast(); //역방향인 경우 맨 뒤 값 버림
                }
            }

            //빈 덱으로 넘어가지 않은 경우
            if (!isContinue) {
                int size = deq.size();
                int x;
                sb.append("[");
                //빈 덱이 아닌 경우 빌더 객체에 값을 넣음
                if (size > 0) {
                    if (isFlag) {
                        for (int i = 0; i < size - 1; i++) {
                            x = deq.pollFirst();
                            sb.append(x).append(",");
                        }
                        sb.append(deq.pollFirst());
                    } else {
                        for (int i = 0; i < size - 1; i++) {
                            x = deq.pollLast();
                            sb.append(x).append(",");
                        }
                        sb.append(deq.pollLast());
                    }
                } else {
                    //isContinue 체크로 빈 덱인 경우 "" 만 넣어 [] 출력
                    //명령어가 먼저 DD 가 들어와서 빈 덱인데 R 이 들어오면 [] 만 출력해야함
                    sb.append("");
                }
                sb.append("]").append("\n");
            }
        }
        System.out.println(sb);
    }
}
