import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int cnt = 0;
        while (n-- > 0) {
            String s = br.readLine();
            boolean isFlag = true;
            for (int i = 0; i < s.length(); i++) {
                if (s.indexOf(s.charAt(i)) != i) {
                    if (s.charAt(i - 1) != s.charAt(i)) {
                        isFlag = false;
                        break;
                    }
                }
            }
            if (isFlag) cnt++;
        }
        System.out.println(cnt);
    }
}
