
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            StringBuilder sb = new StringBuilder();
            for (String str : s.split(" ")) {
                sb.append(new StringBuilder(str).reverse().toString()+" ");
            }
            bw.write(sb.toString());
            bw.write("\n");
        }
        bw.flush();
    }
}
