
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = new String[3];
        for (int i = 0; i < 3; i++) {
            arr[i] = br.readLine();
        }

        int idx = 0;
        int num = 0;
        for (int i = 0; i < 3; i++) {
            String s = arr[i];
            for (int j = 0; j < s.length(); j++) {
                char c = arr[i].charAt(j);
                if (Character.isDigit(c)) {
                    idx = i+1;
                    num = Integer.parseInt(s);
                    break;
                }
            }
        }
        if (idx == 1 && num != 0) {
            num += 3;
        } else if (idx == 2 && num != 0) {
            num += 2;
        } else if (idx == 3 && num != 0) {
            num += 1;
        }

        if (num % 3 == 0 && num % 5 == 0) {
            System.out.println("FizzBuzz");
        } else if (num % 3 == 0 && num % 5 != 0) {
            System.out.println("Fizz");
        } else if (num % 3 != 0 && num % 5 == 0) {
            System.out.println("Buzz");
        } else {
            System.out.println(num);
        }
        System.exit(0);
    }
}
