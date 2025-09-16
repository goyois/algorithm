import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		String str = String.valueOf(n);
		StringBuilder sb = new StringBuilder();
		String answer = "";
		sb.append(str);

		if (n % 2 == 0) {
			sb.append(" is even");
		} else {
			sb.append(" is odd");
		}

		System.out.println(sb.toString());
    }
    
}