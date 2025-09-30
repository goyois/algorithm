import java.util.*;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		sc.close();

		String s = String.valueOf(n);
		char[] arr = s.toCharArray();
		Long[] ans = new Long[arr.length];

		for (int i = 0; i < arr.length; i++) {
			ans[i] = Long.parseLong(String.valueOf(arr[i]));
		}
		Arrays.sort(ans,Collections.reverseOrder());

		for (long x : ans) {
			System.out.print(x);
		}
    }
}