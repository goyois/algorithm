import java.util.*;

class Solution {
    public int[] solution(int n) {
		LinkedList<Integer> list = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			if (n % i == 0) {
				list.add(i);
			}
		}
        
		int[] arr = new int[list.size()];

		for (int i = 0; i < list.size(); i++) {
			arr[i] = list.get(i);
		}
        
        return arr;
    }
}