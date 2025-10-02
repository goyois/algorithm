import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int k = 0; k < n; k++) {
			int x = sc.nextInt();
			String str = sc.next();
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < str.length(); i++) {
				for (int j = 0; j < x; j++) {
					sb.append(str.charAt(i));
				}
			}
			System.out.println(sb.toString());
		}
    }
}