import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();

		String answer = "";
		for (int i = 4; i <= n; i= i+4) {
			answer += "long ";
		}
		System.out.println(answer += "int");
    }
}