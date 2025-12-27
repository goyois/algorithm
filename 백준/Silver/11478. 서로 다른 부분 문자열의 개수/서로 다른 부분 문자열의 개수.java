
import java.io.*;
import java.util.*;

public class Main   {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        HashSet<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i <= s.length(); i++) {
            for (int j = i+1; j <= s.length(); j++) {
                set.add(s.substring(i,j));
            }
        }
        sb.append(set.size());
        System.out.println(sb);
    }
}
