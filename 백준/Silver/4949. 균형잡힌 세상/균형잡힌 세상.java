
import java.io.*;
import java.util.*;

//균형잡힌 세상
public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = "";
        while (true) {
            s = br.readLine();
            if (s.equals(".")) break;
            System.out.println(res(s));
        }

    }


    public static String res(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (c == '(' || c == '[') {
                stack.push(c);
            } else if (c == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else return "no";
            } else if (c == ']') {
                if (!stack.isEmpty() && stack.peek() == '[') {
                    stack.pop();
                } else return "no";
            } else continue;
        }

        if (stack.isEmpty()) {
            return "yes";
        } else return "no";
    }
}
