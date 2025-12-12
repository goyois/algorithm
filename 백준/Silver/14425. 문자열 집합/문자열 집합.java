import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[] arr = new String[n+m];
        for (int i = 0; i < n+m; i++) {
            arr[i] = br.readLine();
        }

        int cnt = 0;
        ArrayList<String> list = new ArrayList<>();
        for (int i = n; i < arr.length; i++) {
            list.add(arr[i]);
        }

        for (int i = 0; i < n; i++) {
            for (String x : list) {
                if (x.equals(arr[i])) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
