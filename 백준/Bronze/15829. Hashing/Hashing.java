import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();

        char[] arr = new char[26];
        char c = (char) 97;
        for (int i = 0; i < 26; i++) {
            arr[i] = c++;
        }

        int idx = 0;
        double sum = 0;
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            for (int j = 0; j < arr.length; j++) {
                if (c1 == arr[j]) {
                    idx = j + 1;
                    sum += idx * Math.pow(31,i);
                    break;
                }
            }
        }
        int answer = (int) sum;
        System.out.println(answer);
    }
}
