import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int answer = 0;
        String a = "ABC DEF GHI JKL MNO PQRS TUV WXYZ";
        String[] arr = a.split(" ");

        for (int i = 0; i < s.length(); i++){
            char x = s.charAt(i);
            for (int j = 0; j < arr.length; j++) {
                if (arr[j].contains(String.valueOf(x))) {
                    answer += j + 3;
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}
