import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int s = 0;
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if (cmd.equals("all")) s = (1 << 21) - 1;
            else if (cmd.equals("empty")) {
                s = 0;
            } else {
                int x = Integer.parseInt(st.nextToken());
                if (cmd.equals("add")) {
                    s |= (1 << x);
                } else if (cmd.equals("remove")) {
                    s &= ~(1 << x);
                } else if (cmd.equals("check")) {
                    sb.append((s & (1 << x)) != 0 ? 1 : 0).append("\n");
                } else if (cmd.equals("toggle")) {
                    s ^= (1 << x);
                }
            }
        }
        System.out.println(sb);
    }
}
