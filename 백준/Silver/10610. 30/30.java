import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        char[] arr = s.toCharArray();
        Arrays.sort(arr);

        long sum = 0;
        boolean check = false;
        StringBuilder sb = new StringBuilder();

        for (int i = arr.length-1; i >= 0; i--) {
            int num = arr[i] - '0';
            sum += num;
            if (num == 0) check = true;
            sb.append(arr[i]);
        }
        if (sum % 3 == 0 && check) System.out.println(sb.toString());
        else System.out.println(-1);
    }
}
