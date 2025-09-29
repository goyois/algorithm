import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		
		int answer = 0;
		for (int i = 1; i <= n; i++) {
			int num = i;
			String s = String.valueOf(num);
			for (int j = 0; j < s.length(); j++) {
				int x = Integer.parseInt(String.valueOf(s.charAt(j)));
				num += x;
			}
			if (num == n) {
				answer = i;
				break;
			}
		}
		System.out.println(answer);
    }
}