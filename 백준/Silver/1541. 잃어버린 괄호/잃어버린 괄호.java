import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(),"-");

        //식에서 만들 수 있는 최댓값을 만들고 최솟값을 찾아서 빼면 된다.
        int sum = Integer.MAX_VALUE;

        while (st.hasMoreTokens()) {
            int tmp = 0;

            StringTokenizer add = new StringTokenizer(st.nextToken(),"+");

            while (add.hasMoreTokens()) {
                tmp += Integer.parseInt(add.nextToken());
            }

            if (sum == Integer.MAX_VALUE) sum = tmp;
            else sum -= tmp;
        }
        System.out.println(sum);
    }
}
