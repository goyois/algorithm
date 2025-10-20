import java.util.*;
class Solution {
    public int solution(int[] nums) {
		int n = nums.length / 2; //구해야하는 포켓몬 종류 수
		int answer = 0;
		HashSet<Integer> set = new HashSet<>();
		for (int x : nums) {
			set.add(x);
		}
		for (int i = 0; i < set.size(); i++) {
			if (i < n) {
				answer++;
			}
		}
        return answer;
    }
}