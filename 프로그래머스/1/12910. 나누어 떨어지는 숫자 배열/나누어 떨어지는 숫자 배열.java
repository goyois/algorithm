import java.util.*;

class Solution {
    public List<Integer> solution(int[] arr, int divisor) {
		ArrayList<Integer> answer = new ArrayList<>();
		int idx = 0;
        
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % divisor == 0) {
				answer.add(arr[i]);
				idx++;
			}
		}

		if (answer.size() != 0) {
			Collections.sort(answer);
		} else {
			if (idx == 0) {
				answer.add(-1);
			}
		}
        return answer;
    }
}