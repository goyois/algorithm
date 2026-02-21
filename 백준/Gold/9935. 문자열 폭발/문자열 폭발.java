
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String x = br.readLine();

        int len = x.length();
        char lastChar = x.charAt(len-1); //trigger

        int loopLen = str.length();
        Stack<Character> stack = new Stack<>();
        StringBuilder sb;

        for (int i = 0; i < loopLen; i++) {
            char c = str.charAt(i);

            if (c == lastChar) {
                sb = new StringBuilder();
                for (int j = 0; j < len -1; j++) {
                    if (stack.isEmpty()) continue;
                    sb.append(stack.pop());
                }
                sb = sb.reverse();
                sb.append(c);
                if (sb.toString().equals(x)) sb.setLength(0); //문자열 폭발
                else for (int j = 0; j < sb.length(); j++) stack.push(sb.charAt(j));
            } else stack.push(c);
        }

        sb = new StringBuilder();
        if (stack.isEmpty()) System.out.println("FRULA");
        else {
            for (char c : stack) sb.append(c);
            System.out.println(sb);
        }
    }
}
