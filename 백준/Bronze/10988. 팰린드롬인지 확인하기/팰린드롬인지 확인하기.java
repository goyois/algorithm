import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int answer = 0;

		StringBuilder sb = new StringBuilder(s);
		String tmp = sb.reverse().toString();
		if (tmp.equals(s)) {
			answer = 1;
		}
		System.out.println(answer);
    }
}