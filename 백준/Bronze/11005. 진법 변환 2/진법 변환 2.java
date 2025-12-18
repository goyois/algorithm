import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        //A: 10 ~ Z: 35
        //만약 0~9 라면 숫자 그대로 쓰고
        //10이 넘어가면 대문자 알파벳으로 표기한다

        int num = n;
        while (num > 0) {
            int tmp = num % b;

            if (tmp > 9) {
                sb.append((char) (tmp+55));
            } else {
                sb.append(tmp);
            }
            
            num /= b;
            
        }
        System.out.println(sb.reverse().toString());
    }
}
