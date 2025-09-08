import java.util.*;

class Solution {
    public int solution(int[] numbers) {        
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers.length; j++) {
				if (i != j) {
					list.add(numbers[i] * numbers[j]);
				}
			}
		}
		int answer = Collections.max(list);
        
        
        return answer;
    }
}