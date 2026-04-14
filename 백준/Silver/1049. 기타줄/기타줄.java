
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int pk = 1001;
        int ea = 1001;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine()," ");
            pk = Math.min(Integer.parseInt(st.nextToken()),pk);
            ea = Math.min(Integer.parseInt(st.nextToken()),ea);
        }
        
        int x = n;
        int hiddenPk = 0;
        while (x > 0) {
            x -= 6;
            hiddenPk += pk;
        }

        int y = n;
        int hiddenEa = 0;
        while (y > 0) {
            y--;
            hiddenEa += ea;
        }

        int answer = 0;
        while (n > 0) {
            if (n > 6) {
                n -= 6;
                answer += pk;
            } else {
                n--;
                answer += ea;
            }
        }
        System.out.println(Math.min(Math.min(hiddenPk,hiddenEa),answer));
    }
}
