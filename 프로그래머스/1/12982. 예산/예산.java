import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        
		if (Arrays.stream(d).sum() == budget) {
			answer = d.length;
		} else {
			Arrays.sort(d);
			for (int i = 0; i < d.length; i++) {
				if (budget >= d[i]) {
					budget = budget - d[i];
					answer++;
				}
			}
		}
        return answer;
    }
}