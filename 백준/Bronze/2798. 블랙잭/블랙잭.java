import java.util.*;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		Integer[] arr = new Integer[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();

		Arrays.sort(arr,Collections.reverseOrder());
		int answer = 0;
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = i+1; j < n; j++) {
				for (int k = j+1; k < n; k++) {
					int pre = arr[i] + arr[j] + arr[k];
					if (pre <= m) {
						list.add(pre);
					}
				}
			}
		}

		answer = Collections.max(list);
		System.out.println(answer);
    }
}