import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        char[] arr = s.toCharArray();

        int cnt0 = 0;
        int cnt1 = 0;

        if (arr[0] == '0') cnt1 += 1;
        else cnt0 += 1;

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] != arr[i + 1]) {
                if (arr[i + 1] == '1') cnt0 += 1;
                else cnt1 += 1;
            }
        }
        System.out.println(Math.min(cnt0,cnt1));
    }
}
