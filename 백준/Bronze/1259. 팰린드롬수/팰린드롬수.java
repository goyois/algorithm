
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String s = br.readLine();
            if (s.equals("0")) break;
            StringBuilder tmpStr = new StringBuilder(s);
            String rvs = tmpStr.reverse().toString();

            if (s.equals(rvs)) sb.append("yes" + "\n");
            else sb.append("no" + "\n");
        }
        System.out.println(sb.toString().stripTrailing());
    }
}
