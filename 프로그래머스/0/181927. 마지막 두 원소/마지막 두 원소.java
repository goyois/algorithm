import java.util.*;

class Solution {
    public List<Integer> solution(int[] num_list) {
		List<Integer> answer = new ArrayList<>();

		for (int n : num_list) {
			answer.add(n);
		}
		
		int n1 = answer.get(answer.size()-1);
		int n2 = answer.get(answer.size()-2);
		
		if (n1 > n2) {
			answer.add(n1 - n2);
		} else if (n1 <= n2) {
			answer.add(n1 * 2);
		}
        return answer;
    }
}