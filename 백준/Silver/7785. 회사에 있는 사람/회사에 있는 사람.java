import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(bf.readLine());
		String[] arr = new String[num];
		for (int j = 0; j < num; j++) {
			arr[j] = bf.readLine();
		}

		HashSet<String> set = new HashSet<>();


		for (int i = 0; i < arr.length; i++) {
			String[] tmp = arr[i].split(" ");
			String emp = tmp[0];
			String status = tmp[1];
			if (status.equals("enter")) {
				set.add(emp);
			} else {
				set.remove(emp);
			}
		}
		ArrayList<String> list = new ArrayList<>(set);
		Collections.sort(list, Collections.reverseOrder());

		for (String s : list) {
			System.out.println(s);
		}
    }
}
