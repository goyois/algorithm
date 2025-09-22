import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
		HashMap<String, Integer> map = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.containsKey(String.valueOf(c))) {
				int v = map.get(String.valueOf(c));
				answer[i] = i - v;
			} 
			else answer[i] = -1;
			
			map.put(String.valueOf(c),i);
		}

        
        return answer;
    }
}